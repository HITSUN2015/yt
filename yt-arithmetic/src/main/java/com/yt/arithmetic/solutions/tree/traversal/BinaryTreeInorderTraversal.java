package com.yt.arithmetic.solutions.tree.traversal;

import com.yt.arithmetic.leetcode.LeetCode;
import com.yt.arithmetic.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreeInorderTraversal implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 94;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        //递归
        traversalNode(root, result);

        return result;
    }

    private void traversalNode(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            traversalNode(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            traversalNode(root.right, result);
        }
    }
}
