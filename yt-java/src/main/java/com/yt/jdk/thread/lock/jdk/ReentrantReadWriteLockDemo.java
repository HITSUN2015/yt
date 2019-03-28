package com.yt.jdk.thread.lock.jdk;


import com.yt.demo.helper.util.ThreadHelper;
import com.yt.demo.helper.util.TimeSleepHelper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yantong on 2019/3/28.
 *
 * 写锁 与 写锁、读锁是互斥的
 *
 * 读锁 与 读锁不互斥
 */
public class ReentrantReadWriteLockDemo implements LockDemo{

    private int value = -1;

    @Override
    public void demo() {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();

        writeThread(writeLock);

        noLockReadThread();

        readLockTread(readLock);
    }

    private void writeThread(Lock writeLock) {
        ThreadHelper.newStartedThread(() -> {
            //                writeLock.lock();一开始 写锁被放在这里 导致读锁 被hang住。。。
            // TODO: 2019/3/28  好像 写锁 优先级 高于 读锁，读一直没有获取到锁
            TimeSleepHelper.sleepSeconds(2);
            writeLock.lock();
            System.out.println("start to write value to " + 1);
            TimeSleepHelper.sleepSeconds(3);
            value = 1;
            System.out.println("finish writing value to " + 1);
            writeLock.unlock();
        });
    }

    private void noLockReadThread() {
        ThreadHelper.newStartedThread(() ->{
            for (int i = 0; i < 10; i++) {
                TimeSleepHelper.sleepSeconds(1);
                System.out.println("第" +i + "次读 no lock value:" + value);
            }
        });
    }

    private void readLockTread(Lock readLock) {
        ThreadHelper.newStartedThread(() -> {
            for (int i = 0; i < 10; i++) {
                TimeSleepHelper.sleepSeconds(1);
                readLock.lock();
                System.out.println("第" +i + "次读 read lock value:" + value);
                readLock.unlock();
            }
        });
    }
}
