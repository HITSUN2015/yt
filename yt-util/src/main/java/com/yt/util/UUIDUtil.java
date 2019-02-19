package com.yt.util;

import java.util.UUID;

/**
 * Created by yantong on 2019/1/7.
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String[] getUUID(int number) {
        if (number < 1) {
            return new String[0];
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public static String getUUIDByLength(int length) {
        if (length <= 0) {
            return null;
        }
        return getUUID().substring(0, length);
    }
}
