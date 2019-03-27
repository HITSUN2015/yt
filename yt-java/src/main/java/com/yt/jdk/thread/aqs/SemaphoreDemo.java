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
 * 常用方法见: {@link SyncIntroduce}
 *
 * 特殊方法:
 *
 * 获取所有资源
 * {@link Semaphore#drainPermits()}
 *
 * 是否公平: true:FIFO false:TODO
 * {@link Semaphore#Semaphore(int, boolean)}
 *
 * 资源个数
 * {@link Semaphore#acquire(int)},{@link Semaphore#release(int)}
 *
 * 检查状态:
 * 剩余资源个数:   {@link Semaphore#availablePermits()}
 * 是否公平:       {@link Semaphore#isFair()}
 * 是否存在竞争:   {@link Semaphore#hasQueuedThreads()}
 * 有多少在竞争:   {@link Semaphore#getQueueLength()}
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
