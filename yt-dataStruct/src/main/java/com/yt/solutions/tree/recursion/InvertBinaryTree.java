package com.yt.solutions.tree.recursion;

import com.yt.leetcode.LeetCode;
import com.yt.solutions.help.TreeNode;

/**
 * Created by yantong on 2019/3/20.
 */
public class InvertBinaryTree implements LeetCode{
    @Override
    public int getProblemNumber() {
        return 0;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode head = root;
        invert(head);
        return head;
    }

    private void invert(TreeNode head) {
        if (null != head) {
            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;
            invert(head.left);
            invert(head.right);
        }
    }
}
