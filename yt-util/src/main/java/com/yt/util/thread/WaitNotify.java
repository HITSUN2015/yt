package com.yt.util.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yantong on 2019/2/15.
 * lock.wait,lock.notify,lock.notifyAll方法必须被 synchronized(lock)包围
 * 如果测试代码 时间上 在wait之前 调用的notify 而之后没再调用 则 wait线程不会被唤醒
 */

public class WaitNotify implements Signal{

    private Object objectLock = new Object();

    private String name;
    private AtomicInteger i = new AtomicInteger(0);

    public WaitNotify(String name) {
        this.name = name;
    }

    public WaitNotify(Object objectLock, String name) {
        this.objectLock = objectLock;
        this.name = name;
    }

    /**
     * 如果这段代码 不被 synchronized包围，则 WaitNotify 对象没有持有objectLock这个对象的锁
     * TODO 以上解释对吗？
     * 会抛出异常：IllegalMonitorStateException
     */
    public void runWait() {
        try {
            i.incrementAndGet();
            int currentValue = i.intValue();
            if (currentValue > 1 && currentValue <= 3) {
                System.out.println(name + currentValue + " before wait");
                objectLock.wait();
                System.out.println(name + currentValue + " after wait");
            } else if (i.intValue() > 3) {
//                System.out.println(name + currentValue + " notify");
//                objectLock.notify();
            }

            System.out.println(name + currentValue + " finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runWaitWithLock() {
        synchronized (objectLock) {
            runWait();
        }
    }
}
