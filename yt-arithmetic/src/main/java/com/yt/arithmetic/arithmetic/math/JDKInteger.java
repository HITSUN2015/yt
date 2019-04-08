package com.yt.arithmetic.arithmetic.math;

/**
 * Created by yantong on 2019/4/2.
 */
public class JDKInteger {

    public void integerDefaultValue() {
        //最高位是0：正数
        //最高位是1：负数
        Integer.toBinaryString(Integer.MAX_VALUE);//1111111111111111111111111111111 31个1

        Integer.toBinaryString(Integer.MIN_VALUE);//10000000000000000000000000000000 31个0

        Integer.toBinaryString(1 << 30);          //1000000000000000000000000000000 31个0
                                                  // integer内，最大的2的指数
    }
}
