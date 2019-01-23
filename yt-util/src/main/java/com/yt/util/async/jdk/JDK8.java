package com.yt.util.async.jdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yantong on 2019/1/22.
 *
 * 此类 主要来测试这个类的使用
 * {@link java.util.concurrent.CompletableFuture}
 *
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

        testExceptionally();
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
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> "Hello");
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
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> "Hello");
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

    private static void sleepSecond(int i) {
        if (i > 0) {
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
