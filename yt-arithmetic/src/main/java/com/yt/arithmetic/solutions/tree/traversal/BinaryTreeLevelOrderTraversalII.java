package com.yt.datastructure.solutions.tree.traversal;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreeLevelOrderTraversalII implements LeetCode {
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

    /**
     * 只是对 {@link BinaryTreeLevelOrderTraversal} 加了个stack
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        Stack<List<Integer>> result = new Stack<>();

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

        List<List<Integer>> finalRestult = new ArrayList<>();

        //这里 一个开始用的peek() != null 结果会跑 stackEmpty 异常
        while (!result.isEmpty()) {
            finalRestult.add(result.pop());
        }
        return finalRestult;
    }

}
