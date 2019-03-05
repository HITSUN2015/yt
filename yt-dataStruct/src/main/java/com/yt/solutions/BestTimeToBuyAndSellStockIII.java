package com.yt.solutions;

import com.yt.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/27.
 */
public class BestTimeToBuyAndSellStockIII implements LeetCode, DynamicProgramming {

    @Override
    public String question() {
        return "Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "\n" +
                "Design an algorithm to find the maximum profit. You may complete at most two transactions.\n" +
                "\n" +
                "Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [3,3,5,0,0,3,1,4]\n" +
                "Output: 6\n" +
                "Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.\n" +
                "             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [1,2,3,4,5]\n" +
                "Output: 4\n" +
                "Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.\n" +
                "             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are\n" +
                "             engaging multiple transactions at the same time. You must sell before buying again.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: [7,6,4,3,1]\n" +
                "Output: 0\n" +
                "Explanation: In this case, no transaction is done, i.e. max profit = 0.";
    }

    @Override
    public int getProblemNumber() {
        return 123;
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
        /**
         * 想半天 没想出咋动态规划
         * 但是想出了个球。。。f[i,j]表示第i天进 第j天卖的赚钱
         * 会出现一个 只有一半值的矩阵，然后从中选 不在同一行 同一列的最大和
         * 但是天数多的话 内存会太大
         *
         */
    }
}
