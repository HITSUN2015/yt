package com.yt.jdk.thread.aqs;

import org.springframework.util.StopWatch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 *
 * {@link java.util.concurrent.Semaphore}
 *
 * 个人理解：旋转木马，只有那几个马能坐，其他人需要等着，有人下马才能有人上马
 *
 * 每个申请者，调用 {@link Semaphore#acquire()}
 *       释放，调用 {@link Semaphore#release()}
 */
public class SemaphoreDemo {

    public void demo() {
        //决定可以并发的量
        int parallelism = 4;
        Semaphore semaphore = new Semaphore(parallelism);

        for (int i = 0; i < 10; i++) {
            //多任务
            new Thread(()->{
                try {
                    StopWatch stopWatch = new StopWatch();
                    stopWatch.start();
                    //抢资源
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(2);
                    //释放资源
                    semaphore.release();
                    stopWatch.stop();
                    System.out.println(this + "work done. time:" + stopWatch.getTotalTimeSeconds());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
