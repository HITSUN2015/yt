package com.yt.jdk.thread.aqs.sync;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 *
 * {@link java.util.concurrent.CountDownLatch}
 *
 * 个人理解：有种，倒计时起跑的感觉，
 *      参赛者预备    {@link CountDownLatch#await()}
 *      发枪者倒计时  {@link CountDownLatch#countDown()}
 *
 * {@link CountDownLatch#CountDownLatch(int n)} 数n个数开始工作，数到0
 */
public class CountDownLatchDemo {

    /**
     预备
     预备
     预备
     预备
     预备
     预备
     预备
     预备
     预备
     预备
     6.0秒后起跑
     6.0秒后起跑
     6.0秒后起跑
     6.002秒后起跑
     6.002秒后起跑
     5.999秒后起跑      咋还有人抢跑。。。可能因为先预备，再计时。。。
     6.0秒后起跑
     6.0秒后起跑
     6.002秒后起跑
     6.002秒后起跑
     */
    public void demo() {
        //决定倒计时多少个数
        int countDown = 3;
        CountDownLatch countDownLatch = new CountDownLatch(countDown);

        for (int i = 0; i < 10; i++) {
            //多任务
            new Thread(() -> {
                System.out.println("预备");
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                try {
                    //等开始命令
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopWatch.stop();
                System.out.println(stopWatch.getTotalTimeSeconds() + "秒后起跑");
            }).start();
        }
        for (int i = countDown; i >= 0; i--) {
            try {
                System.out.println("倒计时 " + i);
                //倒计时
                countDownLatch.countDown();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
