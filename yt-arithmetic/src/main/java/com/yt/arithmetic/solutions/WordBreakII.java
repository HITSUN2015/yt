package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yantong on 2019/2/27.
 */
public class WordBreakII implements LeetCode, DynamicProgramming {

    @Override
    public String question() {
        return "Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "The same word in the dictionary may be reused multiple times in the segmentation.\n" +
                "You may assume the dictionary does not contain duplicate words.\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "s = \"catsanddog\"\n" +
                "wordDict = [\"cat\", \"cats\", \"and\", \"sand\", \"dog\"]\n" +
                "Output:\n" +
                "[\n" +
                "  \"cats and dog\",\n" +
                "  \"cat sand dog\"\n" +
                "]\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "s = \"pineapplepenapple\"\n" +
                "wordDict = [\"apple\", \"pen\", \"applepen\", \"pine\", \"pineapple\"]\n" +
                "Output:\n" +
                "[\n" +
                "  \"pine apple pen apple\",\n" +
                "  \"pineapple pen apple\",\n" +
                "  \"pine applepen apple\"\n" +
                "]\n" +
                "Explanation: Note that you are allowed to reuse a dictionary word.\n" +
                "Example 3:\n" +
                "\n" +
                "Input:\n" +
                "s = \"catsandog\"\n" +
                "wordDict = [\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]\n" +
                "Output:\n" +
                "[]";
    }

    @Override
    public int getProblemNumber() {
        return 140;
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
    public void dynamicProgrammingSolution() {
        //这里 拿过来了 word break的代码

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
