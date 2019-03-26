package com.yt.datastructure.solutions;

import com.yt.datastructure.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.datastructure.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/26.
 */
public class Triangle implements LeetCode, DynamicProgramming {

    @Override
    public String question() {
        return "Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.\n" +
                "\n" +
                "For example, given the following triangle\n" +
                "\n" +
                "[\n" +
                "     [2],\n" +
                "    [3,4],\n" +
                "   [6,5,7],\n" +
                "  [4,1,8,3]\n" +
                "]\n" +
                "The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).";
    }

    @Override
    public int getProblemNumber() {
        return 120;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    @Override
    public void danamicProgrammingSolution() {
        //这道题 感觉 暴力解 比较好。。。
        //f(n) =
        int pow = 2;


    }
}
