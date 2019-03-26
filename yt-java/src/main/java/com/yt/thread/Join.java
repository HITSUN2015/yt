package com.yt.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/2/16.
 *
 * 调用线程 等待 被调用线程 执行完毕
 */

public class Join implements Signal{

    public void demo() {
        Thread sub = new Thread(() -> {
            try {
                System.out.println("子线程开始");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("子线程结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread parent = new Thread(() -> {
            System.out.println("父线程开始");
            sub.start();
            try {
                sub.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("父线程结束");
        });
        parent.start();
        try {
            /**
             * 警告
             * 如果这里 main 线程不join parent 线程，
             * 即使 parent join 了 sub，也不会等待sub完成
             */
            parent.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
