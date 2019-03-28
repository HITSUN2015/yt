package com.yt.demo.helper.util;

/**
 * Created by yantong on 2019/3/28.
 */
public class ThreadHelper {

    public static void newStartedThread(JustDo justDo) {
        new Thread(() ->justDo.justDo()).start();
    }
}
