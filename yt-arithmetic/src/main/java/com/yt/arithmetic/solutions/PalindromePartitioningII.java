package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/26.
 */
public class PalindromePartitioningII implements LeetCode, DynamicProgramming {
    @Override
    public String question() {
        //partition 代表切割
        return "Given a string s, partition s such that every substring of the partition is a palindrome.\n" +
                "\n" +
                "Return the minimum cuts needed for a palindrome partitioning of s.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: \"aab\"\n" +
                "Output: 1\n" +
                "Explanation: The palindrome partitioning [\"aa\",\"b\"] could be produced using 1 cut.";
    }

    @Override
    public int getProblemNumber() {
        return 132;
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
        //这个问题 想了半天，什么以什么结束的回文啊、回文总和是0啊。。。都连不起来n与n-1
        //后来想起 回文类似 圆，我先统计出所有最大半径的圆，然后看一最少方几个圆，感觉可以解这个问题。。。
        //感觉论据有点不足。。。偏贪婪。。。？
        //后来局反例 应该是 还是存在 一个点，取他半径更小的原，也可能组出需要更少的圆的样例
        //但是 又考虑到 求出半径最大的圆后，起内部也都是圆，这个条件，可能可以被利用
        //后来想着想着，好像最后能变成统计出 某个点 都会是哪个圆的边或半径，可以改成跳步的题，最后是算，最少跳几步。。。好像这种题，叫大富翁。。。

    }
}
