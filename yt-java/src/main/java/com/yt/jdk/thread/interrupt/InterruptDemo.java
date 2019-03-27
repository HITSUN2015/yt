package com.yt.jdk.thread.interrupt;/**
 * Created by SUN on 19/3/27.
 */

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author SUN
 * @create 2019-03-27 下午8:21
 * @desc
 *
 * java原生抛出 {@link InterruptedException} 都是该方法需要花费一定时间的
 *      {@link Thread#sleep(long)}
 *      {@link Object#wait()}
 *      {@link Thread#join()}
 *      {@link java.util.concurrent.TimeUnit#SECONDS#sleep()}
 *      {@link Future#get()}
 */
public class InterruptDemo {

    /**
     * 没有打印信息
     */
    public void timeUnitSleep() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("thread inner interrupted");
                e.printStackTrace();
            }
        });
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread outter interrupted");
        }

        stopWatch.stop();
        System.out.println("共历史 " + stopWatch.getTime() / 1000 + " seconds");
    }

    /**
     * 没有打印信息
     */
    public void threadSleep() {
        Thread thread = new Thread(() -> {
            try {
                Thread.currentThread().sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("thread inner interrupted");
                e.printStackTrace();
            }
        });
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread outter interrupted");
        }

        stopWatch.stop();
        System.out.println("共历史 " + stopWatch.getTime() / 1000 + " seconds");
    }

    /**
     * java.util.concurrent.ExecutionException
     * ...
     * Caused by: java.lang.InterruptedException: sleep interrupted
     */
    public void futureSleepOutterInterrupt() {
        FutureTask ft = new FutureTask(() -> {
            TimeUnit.SECONDS.sleep(20);
            return 0;
        });

        Thread thread = new Thread(ft);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        thread.start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }).start();

        try {
            ft.get();
        } catch (InterruptedException e) {
            //没有走这个分支。。。
            System.out.println("ft.get() interrupted");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("出乎意料!!!");
            e.printStackTrace();
        }

        stopWatch.stop();
        System.out.println("共历史 " + stopWatch.getTime() / 1000 + " seconds");
    }


}
