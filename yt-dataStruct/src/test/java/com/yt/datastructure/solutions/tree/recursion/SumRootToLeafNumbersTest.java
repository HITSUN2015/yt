package com.yt.datastructure.solutions.tree.recursion;

import com.yt.datastructure.solutions.help.TreeNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/20.
 */
public class SumRootToLeafNumbersTest {

    @Test
    public void testSolution() {
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();

        TreeNode root = new TreeNode(4);
        TreeNode leaf1 = new TreeNode(9);
        TreeNode leaf2 = new TreeNode(0);
        TreeNode leaf3 = new TreeNode(5);
        TreeNode leaf4 = new TreeNode(1);

        root.left = leaf1;
        root.right = leaf2;

        leaf1.left = leaf3;
        leaf1.right = leaf4;

        int result = solution.sumNumbers(root);
        System.out.println(result);
    }
}
