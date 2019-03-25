package com.yt.datastructure.datastructure.util;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

    /**
     * Object 用来存储 某个特定类型
     * copy from Netty 3.2.9.Final AbstractChannel
     */
    private static final ConcurrentMap<Integer, Object> allObject = new ConcurrentHashMap<Integer, Object>();
    private static Integer getHashIDForInMemryUsage(Object source) {
        Integer id = Integer.valueOf(System.identityHashCode(source));
        for (;;) {
            // Loop until a unique ID is acquired.
            // It should be found in one loop practically.
            if (allObject.putIfAbsent(id, source) == null) {
                // Successfully acquired.
                return id;
            } else {
                // Taken by other channel at almost the same moment.
                id = Integer.valueOf(id.intValue() + 1);
            }
        }
    }
}
