package com.yt.solutions;

import com.yt.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.leetcode.LeetCode;

import java.util.*;

/**
 * Created by yantong on 2019/2/27.
 */
public class WordBreak implements LeetCode, DynamicProgramming{

    @Override
    public String question() {
        return "Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "The same word in the dictionary may be reused multiple times in the segmentation.\n" +
                "You may assume the dictionary does not contain duplicate words.\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"leetcode\", wordDict = [\"leet\", \"code\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"leetcode\" can be segmented as \"leet code\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"applepenapple\", wordDict = [\"apple\", \"pen\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"applepenapple\" can be segmented as \"apple pen apple\".\n" +
                "             Note that you are allowed to reuse a dictionary word.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"catsandog\", wordDict = [\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]\n" +
                "Output: false";
    }

    @Override
    public int getProblemNumber() {
        return 139;
    }

    @Override
    public String performResult() {
        return "Runtime: 2 ms, faster than 100.00% of Java online submissions for Word Break.\n" +
                "Memory Usage: 36.8 MB, less than 72.61% of Java online submissions for Word Break.";
    }

    @Override
    public long getSoluteTime() {
        return 1551250273642l;
    }

    @Override
    public void danamicProgrammingSolution() {
        //这道题 想半天 没想出来，怎么用dp
        //后来回到这个问题本身，bf递归可以解
        //然后就回到，dp的本意是 找到子问题，化简重复计算
        //实则是，第一反应递归，确实慢，但是想的步数太少了，没有在递归里，找到子问题
        //dp 对于看出递归后，就应该再根据递归，看看能不能有子问题，从而引发dp的解法。
        //所以遇到一个问题，不是上来就想dp的状态方程，而是先想递归->子问题
        //这里联想递归："leetcode", wordDict = ["leet", "code"]‘
        //求第一步递归：
        //leetcod e ["leet", "code"]
        //递归1：(leetco d) e
        //递归2：<(leetc o) d> e
        //...
        //l e e t c o d e
        //然后我再回到顶，求剩余两个字母的情况
        //leetco de
        //发现这个leetco 和 递归1的 leetco是一个问题 从而发现子问题
        //从而获得了 f(n)的表达意义，是从0~i个字母 是 符合wordBreak的 这是递归中 的重复子问题
        //但是，子问题 是找到了 如何递归 没找到。。。
        //我这边 第一反应是 求出 distinct length(dictStr)，按这个分类去递归 额 网上的一版就是这么实现的，不过不是按length分类，而是从0找，完全和上面的递归一样
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        Set<String> hashDict = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String s1 : hashDict) {
            maxLength = Math.max(maxLength, s1.length());
        }

        boolean[] dp = new boolean[s.length()];
        for(int i = 0 ; i <  s.length(); i++) {
            if (hashDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                for(int j = i - maxLength  >= 0 ? i - maxLength : 0 ; j < i ; j ++) {
                    if (dp[j] == true && hashDict.contains(s.substring(j + 1 , i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
