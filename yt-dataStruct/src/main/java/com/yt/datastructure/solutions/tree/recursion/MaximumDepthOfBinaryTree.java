package com.yt.datastructure.solutions.tree.recursion;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/3/20.
 */
public class MaximumDepthOfBinaryTree implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 104;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //比较蠢的方法：层序遍历
    public int maxDepth(TreeNode root) {
        //蛋疼 又空指针 必须严厉警告了！！！TODO
        if (null == root) {
            return 0;
        }

        List<List<TreeNode>> levels = new ArrayList<>();
        List<TreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);

        tranversal(rootLevel, levels);

        return levels.size();
    }

    private void tranversal(List<TreeNode> parentLevel, List<List<TreeNode>> levels) {
        if (parentLevel.isEmpty()) {
            return;
        }
        List<TreeNode> curLever = new ArrayList<>();
        for (TreeNode treeNode : parentLevel) {
            if (treeNode.left != null) {
                curLever.add(treeNode.left);
            }
            if (treeNode.right != null) {
                curLever.add(treeNode.right);
            }
        }
        levels.add(curLever);
        tranversal(curLever, levels);
    }
}
