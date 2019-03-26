package com.yt.datastructure.solutions.tree.recursion;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.TreeNode;

/**
 * Created by yantong on 2019/3/20.
 */
public class SumRootToLeafNumbers implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 129;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //一开始 sum 写成了 static 但是 提交 算出结果和我自己测试结果不一样 TODO
    //所以改成 返回值 结果就AC了。。。
    public int sumNumbers(TreeNode root) {

        if(null == root){
            return 0;
        }

        return traversal(root, 0);
    }

    private int traversal(TreeNode curNode, int parentInt) {
        int curSum = parentInt * 10 + curNode.val;
        if (null == curNode.left && null == curNode.right) {
            return curSum;
        }
        int sum = 0;
        if (null != curNode.left) {
            sum += traversal(curNode.left, curSum);
        }
        if (null != curNode.right) {
            sum += traversal(curNode.right, curSum);
        }
        return sum;
    }
}
