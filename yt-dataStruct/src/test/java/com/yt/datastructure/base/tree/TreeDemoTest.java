package com.yt.datastructure.base.tree;/**
 * Created by SUN on 19/3/26.
 */

import com.yt.datastructure.base.DSOperation;
import com.yt.datastructure.base.tree.draw.AbstractDrawalbeTree;
import com.yt.datastructure.baseModel.BTreeNode;
import com.yt.datastructure.demo.tree.AVLTreeDemo;
import com.yt.datastructure.demo.tree.TreeDemo;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-26 下午9:56
 * @desc
 */
public class TreeDemoTest {


    @Test
    public void test() {
        AbstractDrawalbeTree tree = new TreeDemo();
        if (tree instanceof DSOperation) {
            DSOperation operation = (DSOperation) tree;
            operation.add(1);
//        operation.change(2);
            operation.add(2);
            operation.add(3);
        }

        tree.drawTree();
    }

    @Test
    public void testLLRotate() {
        BTreeNode root = new BTreeNode(4);
        root.left = new BTreeNode(2);
        root.right = new BTreeNode(6);
        root.left.left = new BTreeNode(1);
        root.left.right = new BTreeNode(3);
        root.left.left.left = new BTreeNode(0);

        AVLTreeDemo tree = new AVLTreeDemo(root);
        tree.drawTree();

        tree.LLRotate(null, true);
        tree.drawTree();
    }

    @Test
    public void testRRRotate() {
        BTreeNode root = new BTreeNode(4);
        root.right = new BTreeNode(6);
        root.left = new BTreeNode(2);
        root.right.right = new BTreeNode(8);
        root.right.left = new BTreeNode(5);
        root.right.right.right = new BTreeNode(9);

        AVLTreeDemo tree = new AVLTreeDemo(root);
        tree.drawTree();

        tree.RRRotate(null, true);
        tree.drawTree();
    }

    @Test
    public void testLRRotate() {
        BTreeNode root = new BTreeNode(6);
        root.right = new BTreeNode(7);
        root.left = new BTreeNode(3);
        root.left.right = new BTreeNode(5);
        root.left.right.left = new BTreeNode(4);
        root.left.left = new BTreeNode(2);

        AVLTreeDemo tree = new AVLTreeDemo(root);
        tree.drawTree();

        tree.LRRotate(null, true);
        tree.drawTree();
    }

    @Test
    public void testRLRotate() {
        BTreeNode root = new BTreeNode(2);
        root.right = new BTreeNode(7);
        root.left = new BTreeNode(1);
        root.right.right = new BTreeNode(8);
        root.right.left = new BTreeNode(6);
        root.right.left.left = new BTreeNode(5);


        AVLTreeDemo tree = new AVLTreeDemo(root);
        tree.drawTree();

        tree.RLRotate(null, true);
        tree.drawTree();
    }
}
