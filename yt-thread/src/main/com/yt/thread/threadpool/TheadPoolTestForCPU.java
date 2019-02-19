package com.yt.thread.threadpool;/**
 * Created by SUN on 19/1/14.
 */

import java.util.concurrent.*;

/**
 * @author SUN
 * @create 2019-01-14 下午10:43
 * @desc 建立线程池 分析 CPU占用情况
 */
public class TheadPoolTestForCPU {

    public static void main(String[] args) {


//                ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        long curTime = System.currentTimeMillis();
        int threadSumCount = 0;

        while (true) {
            int increaseThreadCount = eazyIncreaseThreadWithTime(threadSumCount, curTime);
            testManyTask(service, increaseThreadCount);
            threadSumCount += increaseThreadCount;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    private static void testManyTask(ExecutorService service, int n) {
        for(int i = 0; i < n; i++) {
            service.execute(()->{
                try {
                    long start = System.currentTimeMillis();
                    Thread t = Thread.currentThread();
                    System.out.println(t.getName() + "开始 执行");
                    TimeUnit.MINUTES.sleep(30);
//                    while (true) {
//                        System.out.println("testprint");
//                    }
                    System.out.println(t.getName() + "结束 执行 " + (System.currentTimeMillis() - start));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static int eazyIncreaseThreadWithTime(int curThreadCount, long startTime) {

        long now = System.currentTimeMillis();

        int functionResult = (int)((now - startTime))/1000;

        int result = increaseFunction(functionResult) - curThreadCount;

        System.out.println("new -> " + result);

        return result;
    }

    private static int increaseFunction(int x) {
        return x * x;
    }
}
