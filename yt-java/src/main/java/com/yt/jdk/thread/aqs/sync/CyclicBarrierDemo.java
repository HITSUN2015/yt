package com.yt.jdk.thread.aqs.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 *
 * {@link java.util.concurrent.CyclicBarrier}
 * 与 {@link java.util.concurrent.CountDownLatch}
 * 的不同：个人认为：
 *  {@link java.util.concurrent.CountDownLatch} 是工人听 管理者命令
 *  {@link java.util.concurrent.CyclicBarrier} 工人 报告工作进度，每个阶段，各工人同时开始工作
 *
 *  {@link CyclicBarrier#CyclicBarrier(int waitCount)} waitCount 多少个做完才能继续
 *  {@link CyclicBarrier#await()} 各个子任务 汇报已经准备完毕
 */
public class CyclicBarrierDemo {

    public void demo() {
        int waitForCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(waitForCount);

        for (int i = 0; i < waitForCount; i++) {
            final Integer sleepTime = i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(sleepTime);
                    System.out.println("可以工作了" + sleepTime);
                    cyclicBarrier.await();
                    System.out.println("继续工作" + sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
