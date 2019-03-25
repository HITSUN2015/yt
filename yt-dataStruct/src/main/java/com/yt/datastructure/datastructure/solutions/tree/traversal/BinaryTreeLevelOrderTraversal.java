package com.yt.datastructure.datastructure.solutions.tree.traversal;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreeLevelOrderTraversal implements LeetCode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();

        //忘了以前层序咋写的了，记得最简单的。。。
        //目前想，需要存储上一层的节点。。。
        List<TreeNode> preLevelNodes = new ArrayList<>();
        preLevelNodes.add(root);

        while (!preLevelNodes.isEmpty()) {
            List<Integer> curLevelNodes = new ArrayList<>();
            List<TreeNode> newLevelNodes = new ArrayList<>();
            for (TreeNode preLevelNode : preLevelNodes) {
                curLevelNodes.add(preLevelNode.val);
                if (preLevelNode.left != null) {
                    newLevelNodes.add(preLevelNode.left);
                }
                if (preLevelNode.right != null) {
                    newLevelNodes.add(preLevelNode.right);
                }
            }
            result.add(curLevelNodes);
            preLevelNodes = newLevelNodes;
        }
        return result;
    }
}
