package com.yt.jdk.math;

/**
 * Created by yantong on 2019/4/2.
 */
public class Number {

    // TODO: 2019/4/2 不理解NaN
    public void isNaN() {
        Float f1 = new Float(0.0 / 0.0);
        System.out.println(f1.isNaN());

        f1 = new Float(-1.0 / 0.0);
        System.out.println(f1.isNaN());
    }
}
