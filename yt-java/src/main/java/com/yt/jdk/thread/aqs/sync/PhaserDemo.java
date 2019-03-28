package com.yt.jdk.thread.aqs.sync;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 *
 * 相比 {@link java.util.concurrent.CyclicBarrier} 提供了 更多的阶段
 */
public class PhaserDemo {

    public void demo() {

        int parallelism = 3;
        Phaser phaser = new Phaser(parallelism);

        for (int i = 0; i < parallelism; i++) {
            final Integer sleepTime = i;
            new Thread(() -> {
                try {
                    System.out.println(sleepTime + ":work1 begin");
                    TimeUnit.SECONDS.sleep(sleepTime);
                    System.out.println(sleepTime + ":work1 end");
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(sleepTime + ":work2 begin");
                    TimeUnit.SECONDS.sleep(sleepTime * 2);
                    System.out.println(sleepTime + ":work2 end");
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(sleepTime + ":work final end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
