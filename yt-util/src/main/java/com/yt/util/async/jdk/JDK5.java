package com.yt.util.async.jdk;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yantong on 2019/1/19.
 *
 * Future {@link Future}
 */
public class JDK5 {

    public static void main(String[] args) {
//        testFutureTaskRunnableMethod();

//        testCallable();

//        testThreadPool();

        testThreadPoolExecutor();
    }

    /**
     * 在JDK1.0~1.2的只提供了Thread、Runnable
     *      如果想在thread外获取result值，需要写通用的代码轮询该变量或者写变动的flag等等等，很蛋疼
     *      现在想不改变Thread、Runnable接口下，定义一个Result类（由于是将来会完成结果，所以起名为Future）
     *      由于Thread、Runnale均不返回结果，所以势必要在二者之间的代码中，把 结果对象 传入
     *      最直接的 就是 Runnable的run方法对 结果对象 赋值
     *
     *      但是代码：
     *      Result rst = new Result()
     *      Runable r = new Runnable(...)
     *      Thread t = new Thread(r)
     *      t.start
     *      rst.getResult()
     *      这么写代码，没法保证rst一定在Runnable里设置过。。。
     *      如果rst.getRsult()不就扯犊子了。。。（这里强行认为没跑完和没设置是两回事）
     *
     *
     *      所以马上能想起来的方法是：把 Runnable 和 Result 合起来：RunnableFuture
     *      由这个类自己去处理把结果放到run方法里的事情
     *      代码就变成了：
     *      RunnableFuture rf = new RunableFuture(
     *          private Object restult;
     *          method:run：。。。 setRestult（）
     *          method:getResult:解决是否set的阻塞,return result;
     *      )
     *      Thread t = new Thread(rf)
     *      t.start()
     *      rf.getResult()
     *      这个方法，需要默认RunableFuture里有个通用的外部可见的变量。TODO   确定
     *      感觉违反了什么东东。。。TODO
     *      以下demo是 jdk5对这种情况的处理，显示的传入result对象
     *
     *      我要是 Doug Lea 面对下面代码也蛋疼
     *      归其原因：thread 和 runnable 都没返回值
     *      那如果对应一个Runnalbe接口有返回值那？ {@link Callable}
     *      这里面我看操作系统级，线程是可以返回一个指针的，不知道为什么没有在thread类里加一个传入Callable的接口。。。TODO
     */
    private static void testFutureTaskRunnableMethod() {
        final String[]  result = new String[1];
        final String[] result2 = new String[1];
        try {
            FutureTask<String[]> future = new FutureTask(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result[0] = "test";
            }, result2);
            //如果这里不写result对象 而写 null，会抛出npt，但是result对象也会被赋值
            //如果这里 写 result2变量，但是run是对result赋值，future get的是null，result被成功赋值，result2无用
            //个人感觉 这个接口 太蛋疼了！！！非严格要求 run的赋值对象与result的对象是同一个

            Thread thread = new Thread(future);
            thread.start();
            try {
                System.out.println("future " + future.get()[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (NullPointerException npt) {
            npt.printStackTrace();
        }
        System.out.println("result" + result[0]);
        System.out.println("result2" + result2[0]);
    }

    /**
     * 其实按照上面我的疑问，如果是我在开发，可能就想方设法把callable塞到thread中，让thread能实现runnable和callable
     *
     * 但是其实按照我目前的项目经验，这么做，如果遇到需求不断在变更，让原有的thread 兼容各种新功能的开发，在考虑兼容性时，还是比较蛋疼的
     *
     * 那么我们来看下，callable 和 runnable到底有什么不同
     *
     * \--------\--------\--------\
     * \        \callable\runnable\
     * \--------\--------\--------\
     * \返回值  \   有   \   无   \
     * \--------\--------\--------\
     * \异常    \   外部 \   内部 \
     * \--------\--------\--------\
     */
    public static void testCallable(){
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("start call");
                for(int i = 0; i < 5 ; i++) {
                    TimeUnit.SECONDS.sleep(1);
                }
                int i = 5 / 0;
                return "call sleep ok";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 各种线程池有其特性，统一用 Excutors来封装
     * 别记忆线程池，用 执行器集合 来记 轻松易懂
     *
     * 额 上面的问题，TODO 可能是由于 线程池的引入，作者并未采用Thread兼容 Runnable 和 Callable
     * 而是建立了ExcutorService 来兼容二者
     * what is Excutor？
     *
     * 警告：有文章表示 禁止用Executors的方法来new线程池
     * 因为等待队列等信息均未知 可能造成OOM
     *
     *
     */
    public static void testThreadPool(){
        /**
         * 多线程时，二者可并发
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("start runable");

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excutorService for runnable");});

        System.out.println("start callalbe");

        Future<String> future = executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excutorService for callable");
            return "ok";
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示的创建线程池
     * {@link ThreadPoolExecutor}
     * https://www.jianshu.com/p/ae67972d1156 这个网址对参数的解读 是可以懂的。
     * 总的来说：
     * 先起核心线程，再入等待队列，等待队列满了，再起非核心线程
     */
    public static void testThreadPoolExecutor(){

//        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
//        int KEEP_ALIVE_TIME = 1;
//        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        BlockingQueue queue = new ArrayBlockingQueue(2);
        //TODO 这里我建立如下的 threadFactory 不会 返回线程
        final AtomicInteger mThreadNum = new AtomicInteger(0);
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                //TODO 这里一定要把runnable传进去。。。否则没效果。。。
                Thread t = new Thread(r, "my-thread-" + mThreadNum.incrementAndGet());
                System.out.println(t.getName() + " has been created");
                return t;
            }
        };

        RejectedExecutionHandler executionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //什么都不干
                System.out.println("异常" + r);
            }
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1,3,10,TimeUnit.SECONDS,queue,factory,executionHandler);

        /**
         * 建立10个任务 结果：
         my-thread-1 has been created
         my-thread-2 has been created
         my-thread-3 has been created
         异常com.yt.util.async.jdk.JDK5$$Lambda$1/1109371569@506c589e
         异常com.yt.util.async.jdk.JDK5$$Lambda$1/1109371569@506c589e
         异常com.yt.util.async.jdk.JDK5$$Lambda$1/1109371569@506c589e
         异常com.yt.util.async.jdk.JDK5$$Lambda$1/1109371569@506c589e
         异常com.yt.util.async.jdk.JDK5$$Lambda$1/1109371569@506c589e
         my-thread-2
         my-thread-1
         my-thread-3
         my-thread-1
         my-thread-2

         为了确定 先进队列的任务不会启动备用线程，所以启动2个任务测试 结果：
         my-thread-1 has been created
         my-thread-1
         my-thread-1
         */
        for(int i = 0 ; i < 2 ; i++) {
            poolExecutor.execute(()->{
                JDK8.sleepSecond(5);
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
