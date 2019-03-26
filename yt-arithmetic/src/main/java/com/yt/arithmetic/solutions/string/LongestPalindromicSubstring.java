package com.yt.arithmetic.solutions.string;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;

/**
 * Created by yantong on 2019/3/21.
 *
 * 这道题有个词 subsequence 是子序列，不要求连续。。。
 *
 * 这道题 第一反应：不会做
 *
 * 后来查询是dp（自己隐约也知道用dp 或 贪婪，就是没思路）
 *
 * 后来看了帖子，突然想：
 * 对于任意一般的String：abcd...
 * 另二维矩阵 横轴 代表 string 开始位置，纵轴代表 string 结束位置
 *
 *       |  0    |  1    |  2  |  3  |
 * |  0  |  a    |       |     |     |
 * |  1  |  ab   |  b    |     |     |
 * |  2  |  abc  |  bc   |  c  |     |
 * |  3  |  abcd |  bcd  |  cd |  d  |
 *
 * 之所以画出来，我是想说，任何string的所有subString 都能用二维数组表达，
 * 我认为这是一个很通用的结论。
 *
 * 我看过的一些一维dp，我认为也可以用二维dp来解，但是是找到某些化简技巧，让二维降为一维了。
 * 所以，我目前是想寻找，是否sring的题，都可以容二维dp来解决
 *
 * 通过观察上图，应该很容易能找出(0,1) 与 （0,0）,（1,1）的关系
 */
public class LongestPalindromicSubstring implements DynamicProgramming {

    /**
     *       |  0    |  1    |  2  |  3  |
     * |  0  |  a    |       |     |     |
     * |  1  |  ab   |  b    |     |     |
     * |  2  |  abc  |  bc   |  c  |     |
     * |  3  |  abcd |  bcd  |  cd |  d  |
     * @param s
     * @return 做题时，就把上面这堆摆这 看着编程，也不用管数组里横向还是竖向存的，认定i就是横，就完事了
     */
    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length() ; i++) {
            for(int j = 0 ; j < s.length() ; j++) {
                if (i > j) dp[i][j] = 0;//图上是空的
                if (i == j) dp[i][j] = 1;//图上的 a,b,c,d 回文长度是1
                if(i < j) {
                    //这种情况 i,j都是合法的，j-1 由于j>i>=0 所以 j-1合法，但是i+1可能不合法，需要独立考虑
                    int before = Math.max(dp[i][j - 1], i + 1 >= s.length() ? 0 : dp[i + 1][j]);
                    //到现在 其实我才开始做题。。。
                    //这里 我想半天 没想出来 ab 和 a,b的关系。。。
                    //abc 和 ab, bc的关系我也没看出来。。。
                    //网上说，只要新增的字母 和 另一头的做比较即可 但是我没想通 为什么
                    //我这边自己能想通的是 新增的字符，去另一边找一样的字符，然后中间的dp[][] + 1 这个我认为是人类能想明白的。。。



                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(154 + 116 + 168 + 199);
    }

    @Override
    public String question() {
        return null;
    }

    @Override
    public void danamicProgrammingSolution() {

    }
}
