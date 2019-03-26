package com.yt.datastructure.leetcode;

/**
 * Created by yantong on 2019/2/26.
 */
public interface LeetCode {

    default String transCArrayToJava(String source) {
        return source.replace("[", "{").replace("]", "}").replace("\"","");
    }

    int getProblemNumber();

    String performResult();

    long getSoluteTime();
}
