package com.yt.datastructure.datastructure.solutions.tree.traversal;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreePreorderTraversal implements LeetCode {

    @Override
    public int getProblemNumber() {
        return 144;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //这个前序 表示的是 跟节点在子节点前面
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        //递归
        traversalNode(root, result);

        return result;
    }

    private void traversalNode(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.left != null) {
            traversalNode(root.left, result);
        }

        if (root.right != null) {
            traversalNode(root.right, result);
        }
    }
}
