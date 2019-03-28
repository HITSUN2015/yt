package com.yt.jdk.thread.lock.jdk;

import com.yt.demo.helper.util.StopWatchHelper;
import com.yt.demo.helper.util.ThreadHelper;
import com.yt.demo.helper.util.TimeSleepHelper;
import com.yt.jdk.thread.lock.jdk.aspect.ReEntrantable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yantong on 2019/3/28.
 *
 * {@link java.util.concurrent.locks.ReentrantLock}
 */
public class ReentrantLockDemo implements LockDemo, ReEntrantable {

    @Override
    public void demo() {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            startNewThreadCatchLock(i, lock);
        }
    }

    private void startNewThreadCatchLock(Integer id, Lock lock) {
        ThreadHelper.newStartedThread(() -> {
            StopWatchHelper.surroundingStopWatch(id + " id ", () -> {
                lock.lock();
                TimeSleepHelper.sleepSeconds(2);
                lock.unlock();//这里 一定要释放 锁
            });
        });
    }
}
