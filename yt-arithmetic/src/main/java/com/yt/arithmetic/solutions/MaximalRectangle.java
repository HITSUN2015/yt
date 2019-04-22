package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import com.yt.arithmetic.leetcode.LeetCode;

/**
 * Created by yantong on 2019/2/26.
 */
public class MaximalRectangle implements LeetCode, DynamicProgramming {

    @Override
    public int getProblemNumber() {
        return 85;
    }

    @Override
    public String question() {
        return "Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [\"1\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"1\",\"0\",\"1\",\"1\",\"1\"],\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"1\"],\n" +
                "  [\"1\",\"0\",\"0\",\"1\",\"0\"]\n" +
                "]\n" +
                "Output: 6";
    }

    @Override
    public String performResult() {
        return null;
    }

    public static void main(String[] args) {
        LeetCode leetCode = new MaximalRectangle();
        String result = leetCode.transCArrayToJava("[\n" +
                "  [\"1\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"1\",\"0\",\"1\",\"1\",\"1\"],\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"1\"],\n" +
                "  [\"1\",\"0\",\"0\",\"1\",\"0\"]\n" +
                "]");
        System.out.println(result);
    }

    @Override
    public long getSoluteTime() {
        return -1l;
    }

    private class RectangleResult {
        private int left;
        private int up;
        private int all;
    }

    @Override
    public void dynamicProgrammingSolution() {

        // TODO: 2019/2/26 看网上 思路 好像 和我这个差不都
        int[][] matrix = new int[][]{
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        //第一反应：f(i,j)是以i,j为最右下角小方格的矩形 的 三种矩形的最大面积
        //但是特殊的是 他有三种情况：
        //1:只有左临格 没有左上格 left
        //1:只有上临格 没有左上格 up
        //1:有左上、左临、上临格 all
        //f(n)返回值是个对象，该对象与f(n-1)是在三个维度上的有子方法的关系

        RectangleResult[][] dp = new RectangleResult[matrix.length][matrix[0].length];
        RectangleResult init = new RectangleResult();
        init.up = matrix[0][0];
        init.left = matrix[0][0];
        init.all = matrix[0][0];
        dp[0][0] = init;

        int maxSize = 0;
        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                RectangleResult curResult = new RectangleResult();
                if (matrix[i][j] != 0) {
                    //这里不能去掉 if else
                    curResult.left = i - 1 >= 0 ? dp[i - 1][j].left + 1 : matrix[i][j];
                    curResult.up = j - 1 >= 0 ? dp[i][j - 1].up + 1 : matrix[i][j];
                    //这里错了，这里需要对 all在建立个模型 记录长、宽 略麻烦了...
                    curResult.all = i - 1 >= 0 && j - 1 >= 0 ? (int)Math.pow((int)Math.sqrt(dp[i - 1][j - 1].all) + 1, 2) : matrix[i][j];

                }
                dp[i][j] = curResult;
                maxSize = Math.max(curResult.left, maxSize);
                maxSize = Math.max(curResult.up, maxSize);
                maxSize = Math.max(curResult.all, maxSize);
            }
        }
        System.out.println(maxSize);
    }
}
