package com.yt.jdk.thread.aqs.cas;/**
 * Created by SUN on 19/3/28.
 */

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
}
