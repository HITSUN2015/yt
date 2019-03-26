package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/26.
 */
public class InterleavingString implements LeetCode, DynamicProgramming {

    @Override
    public String question() {
        return "Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbcbcac\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s1 = \"aabcc\", s2 = \"dbbca\", s3 = \"aadbbbaccc\"\n" +
                "Output: false";
    }

    @Override
    public int getProblemNumber() {
        return 97;
    }

    @Override
    public String performResult() {
        return "Runtime: 3 ms, faster than 72.80% of Java online submissions for Interleaving String.\n" +
                "Memory Usage: 34.4 MB, less than 71.68% of Java online submissions for Interleaving String.";
    }

    @Override
    public long getSoluteTime() {
        return 1551179596175l;
    }

    @Override
    public void danamicProgrammingSolution() {
        //这道题 拿到 就开始 想 各种以什么结尾了。。。
        //f(i,j)代表 以S1[i],S2[j]两个子串，可以构成S3[i+j]

        //TODO 这里关于index 的一点想法
        //现实生活中 一般都没有0
        //所以现实里都用 1~i表示实际意义
        //换成代码索引时，变成：i-1即可
        //如上面 S1[i-1],S2[j-1] S3[(i + 1) + (j + 1) -1]=S3[i + j + 1]

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        //TODO 做了挺长时间 发现我的做法 必须要求 s3 用了 s1,和s2的所有字母
        if (s1.length() + s2.length() != s3.length()) {
            return ;//false
        }

        //做了 好几次 这道题 可能 难度在初始值上。。。

        //额 改了n版，感觉就是我没考虑好 "" 的问题

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        //init
        for (int i = 1; i < s1.length() + 1; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0,i));
        }
        for (int i = 1; i < s2.length() + 1; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0,i));
        }
        dp[0][0] = true;

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length() ; j++) {
                //这个 0,0不好设置 考虑 能不能把 [-1]全设置为true
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else {//// TODO: 2019/2/26 这个在第一次编码时，漏 了 f( i != 0 && j != 0)
                    dp[i][j] = false;
                }
//                for (int m = 0; m < dp.length; m ++) {
//                    for(int n = 0 ; n < dp[0].length ; n++) {
//                        if (m == i && n == j) {
//                            System.out.print("["+ dp[m][n] + "]");
//                        } else {
//                            System.out.print("{"+ dp[m][n] + "}");
//                        }
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
