package com.yt.lamda.jdk.customerLamda;

/**
 * Created by yantong on 2019/1/7.
 */
public class TestClass {

    private int price;

    private Object getValue(CustomerFunctionalInterfaceForLamda lamda) {
        return lamda.getDouble(price);
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.price = 2;
        System.out.println(tc.getValue(x -> x + 0d));
    }
}
