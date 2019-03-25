package com.yt.datastructure.datastructure.solutions.tree.search;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.TreeNode;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by yantong on 2019/3/20.
 *
 * binary search tree (BST)
 *
 * the lowest common ancestor (LCA)
 */
public class LowestCommonAncestorOfABinarySearchTree implements LeetCode {

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

    //这个方法 肯定有毛病
    //做完后想起，应该是 先找到一个节点，然后一个祖先一个祖先的找另一个节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 由于没有指向parent的指针
        // 所以 ：第一反应 找到 根 到 每个节点的 路径
        // 对比 最后一个 相同的就是 最低的 公共 祖先
        Stack<TreeNode> pPath = new Stack();
        findPath(root, p, pPath);
        Stack<TreeNode> qPath = new Stack();
        findPath(root, q, qPath);
        List<TreeNode> plist = pPath.stream().collect(Collectors.toList());
        List<TreeNode> qlist = qPath.stream().collect(Collectors.toList());
        int i = 0;
        for ( ;i < Math.min(plist.size(), qlist.size()) ; i++) {
            if (!plist.get(i).equals(qlist.get(i)))
                break;
        }
        return plist.get(i - 1);
    }

    //感觉 还是 栈的方式遍历 这道题 方便，但是 之前写的是递归。。。
    private boolean findPath(TreeNode root, TreeNode node, Stack<TreeNode> pathStack) {
        pathStack.add(root);
        if (root.equals(node)) {
            return true;
        }

        if (root.left != null) {
            boolean leftResult = findPath(root.left, node, pathStack);
            if (leftResult) {
                return true;
            } else {
                pathStack.pop();

            }
        }

        if (root.right != null) {
            boolean rightResult = findPath(root.right, node, pathStack);
            if (rightResult) {
                return true;
            } else {
                pathStack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        List plist = stack.stream().collect(Collectors.toList());
        System.out.println(plist);
    }
}
