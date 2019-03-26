package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/26.
 */
public class MaximumSubarray implements LeetCode, DynamicProgramming {

    @Override
    public int getProblemNumber() {
        return 53;
    }

    @Override
    public String question() {
        return "Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: [-2,1,-3,4,-1,2,1,-5,4],\n" +
                "Output: 6\n" +
                "Explanation: [4,-1,2,1] has the largest sum = 6.";
    }

    @Override
    public String performResult() {
        return "Runtime: 6 ms, faster than 99.95% of Java online submissions for Maximum Subarray.\n" +
                "Memory Usage: 38.7 MB, less than 89.07% of Java online submissions for Maximum Subarray.";
    }

    @Override
    public long getSoluteTime() {
        return 1551160386856l;
    }

    //TODO 一些其他的设计 https://blog.csdn.net/seagal890/article/details/79439201
    @Override
    public void danamicProgrammingSolution() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //f(n) 表示 以n 结尾的 Max(sum)
        //f(n) = f(n - 1) > 0? f(n-1) + nums[n] : nums[n]

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            dp[i] = dp[i -1] > 0 ? dp[i -1] + nums[i] : nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
