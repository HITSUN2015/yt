package com.yt.util.async;

import java.util.Date;

/**
 * Created by yantong on 2019/1/16.
 */
public class FutureTest {

    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now.getTime());
        Date generate = new Date(1547568000);
        System.out.println(generate);

    }
}
