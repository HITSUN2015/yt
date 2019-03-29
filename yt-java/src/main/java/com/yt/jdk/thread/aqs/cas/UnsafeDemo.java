package com.yt.jdk.thread.aqs.cas;/**
 * Created by SUN on 19/3/28.
 */

import com.yt.demo.helper.util.TimeSleepHelper;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author SUN
 * @create 2019-03-28 下午8:31
 * @desc
 *
 * {@link Unsafe#compareAndSwapInt(Object, long, int, int)}
 * {@link Unsafe#compareAndSwapLong(Object, long, long, long)}
 * {@link Unsafe#compareAndSwapObject(Object, long, Object, Object)}
 *
 * 这个类的演示 为 {@link java.util.concurrent.locks.AbstractQueuedSynchronizer} 提供了在其所有子类、被持有类里 对
 * {@link java.util.concurrent.locks.AbstractQueuedSynchronizer#headOffset}等字段 基于CAS的赋值方法
 */
public class UnsafeDemo {

    public int value = 0;

    /**
     * 获取实例
     *  Unsafe unsafe = Unsafe.getUnsafe();
     *  抛出java.lang.SecurityException: Unsafe
     *  不要调用这个类 直接操作内存
     */
    public static Unsafe getUnsafeInstance() {
        Unsafe unsafe = null;
        Field singleoneInstanceField = null;
        try {
            singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            unsafe = (Unsafe)singleoneInstanceField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return unsafe;
    }

    /**
     * 获取某个字段在内存中的偏移量
     *
     * 注意1: 一开始我把 测试的 field 设置成了 静态变量 抛出 java.lang.IllegalArgumentException
     *
     * 这里我原以为,必须new 出实例 才能找到偏移量 但是 好像不是。TODO 有的人说 这个是给出堆地址的偏移量
     */
    public static long getFieldOffset(Class classInstance, String fieldName) {
        try {
            Field field = classInstance.getDeclaredField(fieldName);
            return getUnsafeInstance().objectFieldOffset(field);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(classInstance.getName() + "not exists field:" + fieldName);
        }
    }

    /**
     * 修改对象 指定属性的值中的值
     *
     * cas一般都在循环中,expect必须重新获取
     */
    public static boolean compareAndSet(Object instance, String fieldName, int expect, int value) {
        long offset = getFieldOffset(instance.getClass(), fieldName);
        return getUnsafeInstance().compareAndSwapInt(instance, offset, expect, value);
    }

    /**
     * 向对象赋值的另一种方法 非CAS
     *
     * TODO 这种写法 未 通过测试 不知道为什么 设成了一个负值
     */
    public static void objectSetProperty(Object instance, String fieldName, int value) {
        long offset = getFieldOffset(instance.getClass(), fieldName);
        int value2 = getUnsafeInstance().getInt(instance, offset);
        getUnsafeInstance().putObject(instance, offset, value);
        value2 = getUnsafeInstance().getInt(instance, offset);
    }


     /**
     * 操作线程
     *
     * {@link Unsafe#park(boolean, long)}
     *      参数1：boolean isAbsolute
     *      Block current thread, returning when a balancing
     *      <tt>unpark</tt> occurs, or a balancing <tt>unpark</tt> has
     *      already occurred, or the thread is interrupted, or, if not
     *       absolute and time is not zero, the given time nanoseconds have
     *       elapsed, or if absolute, the given deadline in milliseconds
     *       since Epoch has passed, or spuriously (i.e., returning for no
     *       "reason"). Note: This operation is in the Unsafe class only
     *       because <tt>unpark</tt> is, so it would be strange to place it
     *       elsewhere.
     *       true->isAbsolute->绝对时间->微秒
     *       false->notAbsolute->相对时间->纳秒
     *       TODO 为什么绝对时间反而不精确，我这里理解的是，绝对时间是能保证的，相对时间是无法保证的。。。
     *       根据这个参数，可以给thread的hang提供定时功能
     *       对应 {@link java.util.concurrent.locks.LockSupport#parkNanos(long)} 纳秒 isAbsolute:false
     *            {@link java.util.concurrent.locks.LockSupport#parkUntil(long)} 毫秒 isAbsolute:true
     *       这里还应该强调的是：如果之前调用过unpark 和 interrupt 会直接返回 TODO demo
     *
     * 是主动方法，谁调用就停谁
     *
     * {@link Unsafe#unpark(Object)}
     *
     * 是被动方法，传入需要唤醒的对象
     */
    public static void controlThread() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                TimeSleepHelper.sleepSeconds(1);
                System.out.println(i);
                if (i % 3 == 2) {
                    getUnsafeInstance().park(false, 0l);
                }
            }
        });
        t.start();

        for (int i = 0; i < 10; i++) {
            TimeSleepHelper.sleepSeconds(5);
            getUnsafeInstance().unpark(t);
        }
    }
}
