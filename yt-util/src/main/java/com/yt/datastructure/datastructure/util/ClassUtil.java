package com.yt.datastructure.datastructure.util;

/**
 * Created by yantong on 2019/3/1.
 */
public class ClassUtil {

    /**
     * 这里只是展示下写法 不用来使用
     * 另外 如果是祖先的class 也会返回true
     * @param tClass
     * @param o
     * @return
     */
    public static boolean isInstance(Class tClass, Object o) {
        if (tClass.isInstance(o)) {
            return true;
        }
        return false;
    }
}
