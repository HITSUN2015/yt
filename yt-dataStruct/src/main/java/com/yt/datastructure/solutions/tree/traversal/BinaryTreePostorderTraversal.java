package com.yt.datastructure.solutions.tree.traversal;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreePostorderTraversal implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 145;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
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

        if (root.right != null) {
            traversalNode(root.right, result);
        }

        result.add(root.val);
    }
}
