package com.yt.demo.helper.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/28.
 */
public class TimeSleepHelper {

    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
