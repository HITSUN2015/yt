package com.yt.solutions.tree.recursion;

import com.yt.leetcode.LeetCode;
import com.yt.solutions.help.TreeNode;

/**
 * Created by yantong on 2019/3/20.
 */
public class PathSum implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 112;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }
        return traversal(root, 0, sum);
    }

    private boolean traversal(TreeNode root, int parentCount, int sum) {
        int curValue = parentCount + root.val;//这里 不要因为曾经编过而惯性写。。。 * 10 +....
        if (root.left == null && root.right == null) {
            if (curValue == sum) {
                return true;
            }
            return false;
        }
        boolean result = false;
        if (root.left != null) {
            result |=traversal(root.left, curValue, sum);
        }
        if (root.right != null) {
            result |=traversal(root.right, curValue, sum);
        }
        return result;
    }
}
