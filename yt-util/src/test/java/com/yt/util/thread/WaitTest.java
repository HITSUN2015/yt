package com.yt.util.thread;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/2/15.
 */
@Test
public class WaitTest {

    @Test
    public void testImplByWait() {
        Object outterLock = new Object();
        Wait wait1 = new Wait(outterLock, "waiter-");

        /**
         如果不起线程 直接调用，main线程会被阻塞
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         wait1.runWaitWithLock();
         */

        Thread t1 = new Thread(() -> wait1.runWaitWithLock());
        Thread t2 = new Thread(() -> wait1.runWaitWithLock());
        Thread t3 = new Thread(() -> wait1.runWaitWithLock());
        Thread t4 = new Thread(() -> wait1.runWaitWithLock());
        Thread t5 = new Thread(() -> wait1.runWaitWithLock());
        Thread t6 = new Thread(() -> wait1.runWaitWithLock());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        new Thread(() -> {
            while (true) {
                notifyTest(outterLock);
            }
        }).start();

         //这个join调用 会 由wait的线程 直接阻塞住main线程
//         try {
//             t1.join();
//             t2.join();
//             t3.join();
//             t4.join();
//             t5.join();
//             t6.join();
//         } catch (InterruptedException e) {
//            e.printStackTrace();
//         }

        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void notifyTest(Object lock) {
        synchronized (lock) {
            lock.notify();
        }
    }
}
