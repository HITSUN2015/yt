package com.yt.datastructure.datastructure.solutions.tree.recursion;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by yantong on 2019/3/20.
 */
public class PathSumII implements LeetCode {

    @Override
    public int getProblemNumber() {
        return 113;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        Stack<Integer> pathStack = new Stack();
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, sum, pathStack, result);
        return result;
    }

    //stack pop的位置 改了两次都没对！！第一次 结尾少pop 第二次 第一次pop后没return
    private void traversal(TreeNode root, int parentCount, int sum, Stack<Integer> pathStack, List<List<Integer>> result) {
        int curValue = parentCount + root.val;//这里 不要因为曾经编过而惯性写。。。 * 10 +....
        pathStack.add(root.val);
        if (root.left == null && root.right == null) {
            if (curValue == sum) {
                result.add(pathStack.stream().collect(Collectors.toList()));
            }
            pathStack.pop();
            return;
        }
        if (root.left !=  null) {
            traversal(root.left, curValue, sum, pathStack, result);
        }
        if (root.right != null) {
            traversal(root.right, curValue, sum, pathStack, result);
        }
        pathStack.pop();

    }
}
