package com.yt.datastructure.solutions.tree.recursion;

import com.yt.datastructure.solutions.help.TreeNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/20.
 */
public class PathSumIIITest {

    @Test
    public void test() {
        PathSumIII solution = new PathSumIII();

        TreeNode root = new TreeNode(10);
        TreeNode leaf1 = new TreeNode(5);
        TreeNode leaf2 = new TreeNode(-3);
        TreeNode leaf3 = new TreeNode(3);
        TreeNode leaf4 = new TreeNode(2);
        TreeNode leaf5 = new TreeNode(11);
        TreeNode leaf6 = new TreeNode(3);
        TreeNode leaf7 = new TreeNode(-2);
        TreeNode leaf8 = new TreeNode(1);

        root.left = leaf1;
        root.right = leaf2;

        leaf2.right = leaf5;

        leaf1.left = leaf3;
        leaf1.right = leaf4;

        leaf4.right = leaf8;

        leaf3.left = leaf6;
        leaf3.right = leaf7;

        int result = solution.pathSum(root, 8);
    }
}
