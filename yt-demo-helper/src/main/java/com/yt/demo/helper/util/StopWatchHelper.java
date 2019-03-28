package com.yt.demo.helper.util;

import org.springframework.util.StopWatch;

/**
 * Created by yantong on 2019/3/28.
 */
public class StopWatchHelper {

    public static void surroundingStopWatch(String message, JustDo justDo) {
        StopWatch stopWatch = new StopWatch();
        System.out.println(message + " begin");
        stopWatch.start();
        justDo.justDo();
        stopWatch.stop();
        System.out.println(message + " end, duration " + stopWatch.getTotalTimeSeconds() + "seconds");
    }
}