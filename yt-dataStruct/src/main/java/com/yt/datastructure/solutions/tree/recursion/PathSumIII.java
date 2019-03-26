package com.yt.datastructure.solutions.tree.recursion;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.TreeNode;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by yantong on 2019/3/20.
 */
public class PathSumIII implements LeetCode {


    @Override
    public int getProblemNumber() {
        return 437;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //这道题 我观察的主要因素是 必须连续节点 所以有了如下方法
    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }

        Stack<Integer> pathStack = new Stack<>();
        int result = tranversal(root, pathStack, sum);
        return result;
    }

    //返回 经过 node 的 和为sum的 个数
    private int tranversal(TreeNode node, Stack<Integer> pathStack, int sum) {
        //calculate current node
        pathStack.add(node.val);
        List<Integer> valueList = pathStack.stream().collect(Collectors.toList());
        int curValue = 0;
        int result = 0;
        for (int i = valueList.size() -1; i >= 0 ; i--) {
            curValue += valueList.get(i);
            if (curValue == sum) {
                result++;
            }
        }

        if (node.left != null) {
            result += tranversal(node.left, pathStack, sum);
        }
        if (node.right != null) {
            result += tranversal(node.right, pathStack, sum);
        }
        pathStack.pop();//这里忘记了 pop 一定要记得 stack 严肃考虑 pop
        return result;
    }
}
