package com.yt.jdk.async;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/1/18.
 * {@link Thread}
 * {@link Runnable}
 *
 * 了解一个线程，重要是了解他的维度：
 * 维度1:线程的优先级
 * 维度2：线上是否是守护线程
 * 维度3：线程组：
 *          设置：线程池 默认的线程组，可能由SecurityManager生成，改写方法可以为传入自定义的线程Factory
 *          应用：1.统一处理 未捕获异常：https://blog.csdn.net/evankaka/article/details/51627380
 *                2.在具有数千个线程的大型应用程序服务器中，可能是一种有用的诊断技术。如果线程在逻辑上被分组在一起，那么当得到堆栈跟踪时，可以看到哪个组是违规线程的一部分(例如：“Tomcat线程”、“MDB线程”、“线程池X”等)，这对跟踪和解决问题有很大帮助。
 *          反应用：不要用ThreadGroup新代码。使用Executorjava.util.concurrent
 *                  也挺多说这个 不好的
 * 维度4：状态Thread.State https://blog.csdn.net/jiangguojian0320/article/details/53247113
 *
 * 警告：这个类的代码，在实际应用中 均不采纳使用
 * 1：显示的调用线程，并发量大的时候，增大线程资源的切换
 * 2：如果匿名建立线程，排错、性能分析，不便
 *
 */
public class JDK1 {
    public static void main(String[] args) {
        testThreadRunAndStart();

        testThreadReturnResultToOutSide();

        testThreadControl();
    }

    private static void testThreadRunAndStart() {
        //Runnable只是一个接口 单独执行只会作为一个普通的类，而非分配子线程
        Runnable runnable = () -> {
            System.out.println("[" + Thread.currentThread().getName() + "] test Runnable instance");
        };
        runnable.run();

        Thread thread = new Thread(runnable);
        //thread 的 run方法 也只是 一个 主线程执行 target中的代码
        thread.run();
        //start方法是建立子线程
        thread.start();
    }

    // TODO: 2019/1/18
    private static void testThreadControl() {
        Thread sleepThread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void testThreadReturnResultToOutSide() {
        String[] result = new String[1];
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result[0] = "result";
        });
        t.start();
        do {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(result[0]);
        } while (null == result[0]);
        System.out.println(result[0]);//保证至少打印一次
    }
}
