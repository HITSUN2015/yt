package com.yt.datastructure.datastructure.solutions.tree.recursion;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.TreeNode;

import java.util.*;

/**
 * Created by yantong on 2019/3/20.
 */
public class BinaryTreePaths implements LeetCode {


    @Override
    public int getProblemNumber() {
        return 257;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) {
            return Collections.EMPTY_LIST;
        }
        Stack<Integer> pathStack = new Stack<>();
        List<String> result = new ArrayList<>();
        tranversal(root, pathStack, result);
        return result;
    }

    private void tranversal(TreeNode root, Stack<Integer> pathStack, List<String> result) {
        pathStack.add(root.val);
        if (null == root.left && null == root.right) {
//             一开始 这么写的，但是输出是："->fasdf->dsf" 有个初始值 后改成下面的
//            String curString = pathStack.stream().map(String::valueOf).reduce("", (x, y) -> x + "->" + y);
//            result.add(curString);

            //Optional<String> curString 报错
            String curString = pathStack.stream().map(String::valueOf).reduce((x, y) -> x + "->" + y).get();
            result.add(curString);
        }

        if (null != root.left) {
            tranversal(root.left, pathStack, result);
        }
        if (null != root.right) {
            tranversal(root.right, pathStack, result);
        }

        pathStack.pop();
    }
}
