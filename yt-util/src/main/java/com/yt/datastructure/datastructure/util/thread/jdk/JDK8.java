package com.yt.datastructure.datastructure.util.thread.jdk;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author SUN
 * @create 2019-01-22 下午9:47
 * @desc 展示一些java8关于线程的应用
 */
public class JDK8 {

    /**
     * 这里不做对 guava 和 jdk8的比较,因为guava是先出的,jdk效仿了其中很多优点。
     * 后面会总结 对 同样 功能 的不同实现的 比较
     */
    public void testCompletableFuture() {

    }

    private class Test{}

    private class Shop {
        private String name;
        private Random random = new Random();

        public Shop(String name) {
            this.name = name;
        }

        //直接获取价格
        public double getPrice(String product){
            return calculatePrice(product);
        }
        //模拟延迟
        public void delay(){
            try {
                Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //模拟获取价格的服务
        private double calculatePrice(String product){
            delay();
            return random.nextDouble() * product.charAt(0) + product.charAt(1);
        }

        //异步获取价格
        public Future<Double> getPriceAsync(String product){
            CompletableFuture<Double> future = new CompletableFuture<>();
            new Thread(() -> {
                double price = calculatePrice(product);
                future.complete(price);
            }).start();
            return future;
        }
    }
}
