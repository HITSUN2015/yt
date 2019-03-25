package com.yt.datastructure.datastructure.solutions;

/**
 * Created by yantong on 2019/2/27.
 * 额。。。BF 用来用子串 匹配 字符串的。。。叫暴力破解
 */
public class BruteForce {

    public boolean bfSolution(String source, String fakePattern) {
        if (null == source || null == fakePattern || source.length() < fakePattern.length()) {
            return false;
        }
        for(int i = 0; i <= source.length() - fakePattern.length(); i ++) {
            if (source.substring(i, i + fakePattern.length()).equals(fakePattern)) {
                return true;
            }
        }
        return false;
    }
}
