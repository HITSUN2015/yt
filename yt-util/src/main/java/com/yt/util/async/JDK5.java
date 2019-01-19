package com.yt.util.async;

import java.util.concurrent.*;

/**
 * Created by yantong on 2019/1/19.
 *
 * Future {@link Future}
 */
public class JDK5 {

    public static void main(String[] args) {
        testFutureTaskRunnableMethod();
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
}
