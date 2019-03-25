package com.yt.datastructure.datastructure.solutions;

import com.yt.datastructure.datastructure.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.datastructure.datastructure.arithmetic.greedy.Greedy;
import com.yt.datastructure.datastructure.leetcode.LeetCode;


/**
 * Created by yantong on 2019/2/26.
 */
public class JumpGame  implements LeetCode, DynamicProgramming, Greedy {

    @Override
    public int getProblemNumber() {
        return 55;
    }

    @Override
    public String question() {
        return "Given an array of non-negative integers, you are initially positioned at the first index of the array.\n" +
                "\n" +
                "Each element in the array represents your maximum jump length at that position.\n" +
                "\n" +
                "Determine if you are able to reach the last index.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [2,3,1,1,4]\n" +
                "Output: true\n" +
                "Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [3,2,1,0,4]\n" +
                "Output: false\n" +
                "Explanation: You will always arrive at index 3 no matter what. Its maximum\n" +
                "             jump length is 0, which makes it impossible to reach the last index.";
    }

    /**
     * 后面经过查资料，发现，也有我这种实现的
     * 但是，同样是动态规划算法，不同定义f（n），实现难度和效率也都是不一样的
     *
     * 再来考虑下别人的动态规划的思想，从而总结下，都可能有什么样的维度来想问题
     */
    @Override
    public void danamicProgrammingSolution() {
        int[] nums = new int[]{2,3,1,1,4};

        //第一反应是，能否跳到某一步，作为f(n)
        //线统计最大的跳跃步数m，做个m*n数组

        int m = 0;
        for (int num : nums) {
            m = m > num ? m : num;
        }

        //calculate 第一层length是 nums.length

        //做着做着，由于结果是boolean，所以我不用记录每一步由哪一步跳过来的，只需要根据calculate查询下f(i)是否是true

        boolean[] result = new boolean[nums.length];
        result[0] = true;
        //TODO 是否有 方法 不去考虑这些下标。。。
        //这里做一下化简，不要这个delt 减来减去的，给出从哪开始遍历
        for(int i = 1 ; i < nums.length ; i++) {
            int startIndex = i - m>= 0 ? i - m: 0;
            boolean curResult = false;
            for(; startIndex < i ; startIndex++) {
                if (nums[startIndex] >= i - startIndex  && result[startIndex]) {
                    curResult = true;
                    //这里可以加 break
                }
            }
            result[i] = curResult;
        }
        System.out.println(result[result.length - 1]);
    }

    public static void anotherDPSolution() {
        //f(n):到达这步后，剩余的最大步数
        int[] nums = new int[]{2,3,1,1,4};
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length ; i++) {
            //如下代码 wrong
            //dp[i] = dp[i - 1] > nums[i] ? dp[i - 1] - 1 : nums[i] - 1;
            if (dp[i - 1] > 0) {
                dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            } else {
                dp[i] = -1;
            }
        }
        System.out.println(dp[dp.length - 1] >= 0);
        /**
         * Runtime: 4 ms, faster than 92.80% of Java online submissions for Jump Game.
         * Memory Usage: 40.3 MB, less than 49.44% of Java online submissions for Jump Game.
         */
    }

    @Override
    public String performResult() {
        return "Runtime: 175 ms, faster than 29.15% of Java online submissions for Jump Game.\n" +
                "Memory Usage: 41.1 MB, less than 27.28% of Java online submissions for Jump Game.";
    }

    @Override
    public long getSoluteTime() {
        return 1551147733749l;
    }

    @Override
    public void greedySolution() {
        // TODO: 2019/2/26
    }
}
