package com.yt.arithmetic.solutions;

import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/27.
 */
public class BestTimeToBuyAndSellStock implements LeetCode {

    public String question() {
        return "Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "\n" +
                "If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.\n" +
                "\n" +
                "Note that you cannot sell a stock before you buy one.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [7,1,5,3,6,4]\n" +
                "Output: 5\n" +
                "Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.\n" +
                "             Not 7-1 = 6, as selling price needs to be larger than buying price.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [7,6,4,3,1]\n" +
                "Output: 0\n" +
                "Explanation: In this case, no transaction is done, i.e. max profit = 0";
    }

    @Override
    public int getProblemNumber() {
        return 121;
    }

    @Override
    public String performResult() {
        return "Runtime: 1 ms, faster than 99.69% of Java online submissions for Best Time to Buy and Sell Stock.\n" +
                "Memory Usage: 36.3 MB, less than 86.76% of Java online submissions for Best Time to Buy and Sell Stock.";
    }

    @Override
    public long getSoluteTime() {
        return 1551255636905l;
    }

    public void Solution() {
        //突然想出了 j->i,k->j 可以求出 k->i,所以 动态规划就出来了..
        //f(n)= max(f(i:0~n-1) + n->i//后发现这个方程错了！！！都是对第一项的差值了。。。
        //由于先做的III，感觉这里又变成那个三角形了。。。
        //结果这道题 不需要dp。。。因为卖必须在买之后，所以还造成了都能在一个for循环里更新最值。。。
        int[] prices = new int[]{7,1,5,3,6,4};
//        if (prices.length < 2) {
//            return;//0;
//        }
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        dp[1] = prices[1] - prices[0];
//        for(int i = 1; i < dp.length ; i++) {
//            int maxProfit = Integer.MIN_VALUE;//第一次提交就错了，如果允许负数，则这里需要设置为最小值
//            for(int j = 0 ; j < i ; j++) {
//                maxProfit = Math.max(dp[j] + prices[i] - prices[j], maxProfit);
//            }
//            dp[i] = maxProfit;
//        }
//        for (int i : dp) {
//            System.out.println(i);
//        }
//        System.out.println(dp[dp.length - 1]);

        if(prices.length < 2){
            return ;//0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 1; i< prices.length; i++){
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }
        System.out.println(max > 0 ? max : 0);
    }
}
