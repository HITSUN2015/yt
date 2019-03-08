package com.yt.util;

/**
 * Created by yantong on 2019/3/8.
 */
public class CPUUtil {

    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
