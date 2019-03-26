package com.yt.async;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yantong on 2019/1/22.
 *
 * 此类 主要来测试这个类的使用
 * {@link java.util.concurrent.CompletableFuture}
 *
 * 总结 CompletableFuture实现方法
 */
public class JDK8 {

    /**
     * {@link java.util.concurrent.CompletionStage}
     * @param args
     */
    public static void main(String[] args) {
//        testThenApply();

//        testThenApplyAsync();

//        testThenCombine();

//        testApplyToEither();

//        testThenCompose()

//        testExceptionally();

//        testWhenComplete();

        test();
    }

    /**
       printFuture(future1)：

             23:01:28


             23:01:33

             Hello
             23:01:33
       printFuture(future2)

             23:01:56


             23:01:01

             Hello World
             23:01:01
       1.不会根据future2没有被用到就 不必执行来优化
       2.thenApply是严格串行的
     */
    private static void testThenApply() {
        printFuture(null);
        CompletableFuture future1 = CompletableFuture.completedFuture("Hello");
        CompletableFuture future2 = future1.thenApply(x ->{
            sleepSecond(5);
            return x + " World";});
        printFuture(null);
        printFuture(future1);
    }

    /**
     printFuture(future1)

         23:01:46


         23:01:46

         Hello
         23:01:46
     printFuture(future2)

         23:01:04


         23:01:04

         Hello World
         23:01:09
        1.异步工作会根据 是否需要计算来进行优化：printFuture(future1) 三个时间一致
        2.异步 默认的是forkJoinPool TODO 这里是根据某些配置 来决定是否默认为forkJoin
     */
    private static void testThenApplyAsync() {
        printFuture(null);
        CompletableFuture future1 = CompletableFuture.completedFuture("Hello");
        CompletableFuture future2 = future1.thenApplyAsync(x ->{
            sleepSecond(5);
            return x + " World";});
        printFuture(null);
        printFuture(future2);
    }

    /**
     * 这里略去
     * 同步：then 异步：async 可传入线程池的 async
     * 有入参和出参的：apply 只有入参的：accept 没有入参也没有返回值的 run的demo
     */


    /**
     * 以下略去 async、asyncWithExecutors的方法测试
     */

    /**

     23:01:46

     Hello World
     23:01:49
        三秒 并行
        类似的有：thenAcceptBoth runAfterBoth
     */
    private static void testThenCombine() {
        printFuture(null);
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> {
            sleepSecond(2);
            return "Hello";});
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            sleepSecond(3);
            return "World";});
        CompletableFuture future3 = future1.thenCombine(future2,(x,y)->{
            return x + " " + y;
        });
        printFuture(future3);
    }

    /**
     *
     23:01:44

     Hello ether
     23:01:51
     */
    private static void testApplyToEither() {
        printFuture(null);
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> {
            sleepSecond(2);
            return "Hello";});
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            sleepSecond(3);
            return "World";});
        CompletableFuture future3 = future1.applyToEitherAsync(future2,(x)->{
            sleepSecond(5);
            return x + " ether";
        });
        printFuture(future3);
    }

    /**
     * thenCompose 里面可以添加新的 CompletableFuture
     * TODO 没get到这个的用法
     */
    private static void testThenCompose() {

    }

    /**
     * 某个流程执行了 Excepitonalli 就不会再把异常抛到 future.get
     * RuntimeException 是 Exception
     */
    private static void testExceptionally() {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> 9 / 0).exceptionally((e) -> {
            System.out.println(e);
            return -1;
        });
        printFuture(cf);

        CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> 9 / 0);
        printFuture(cf2);
    }

    /**
     * 简单来看就 是能分别处理 返回的结果和 异常
     *
     * TODO
     */
    private static void testWhenComplete(){
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> 9 / 0)
                .whenCompleteAsync((x, e) -> {
                    System.out.println(x);
                    System.out.println(e);
                });
        printFuture(cf);
    }

    /**
     * TODO
     */
    private static void testHandle() {

    }

    /**
     * 静态方法提供了一些 类似 Completable 接口中 both、ether、无入参但是有返回、是否异步的方法、直接返回结果的方法
     */
    private static void testComletableStaticFunction() {
        CompletableFuture completableFuture = CompletableFuture.completedFuture("test");
        // 略
    }


    private static void printFuture(Future future) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:ss\n");
            /**
             * 这里原来的写法是：打印时间 紧接着打印future.get()，但是时间实际是 get执行前生成的，并不能反get的执行时间
             */
            System.out.println( null == future? "" : future.get().toString());
            System.out.println(sdf.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSecond(int i) {
        if (i > 0) {
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FutureTask parentFuture = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                FutureTask futureTask = new FutureTask(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        while (true) {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("inner");
                        }
                    }
                });
                executorService.submit(futureTask);
                try {
                    futureTask.get(2, TimeUnit.SECONDS);
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                futureTask.cancel(true);// TODO: 2019/1/31 这里还是应该停下来的 主要看 任务 是否 完成
                TimeUnit.SECONDS.sleep(20);
                return null;
            }
        });
        executorService.submit(parentFuture);
        try {
            parentFuture.get(40, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
