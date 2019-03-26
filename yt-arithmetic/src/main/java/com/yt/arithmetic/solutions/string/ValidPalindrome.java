package com.yt.datastructure.solutions.string;

import com.yt.datastructure.leetcode.LeetCode;

/**
 * Created by yantong on 2019/3/20.
 */
public class ValidPalindrome implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 125;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //这题 看半天 没看懂，原来是 去掉 符号 空格是 回文的。。。
    public boolean isPalindrome(String s) {
        if (null == s || s.isEmpty()) {
            return false;
        }



        return false;
    }

}
