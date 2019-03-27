package com.yt.datastructure.demo.tree;/**
 * Created by SUN on 19/3/26.
 */

import com.yt.datastructure.base.tree.AVLTree;
import com.yt.datastructure.base.tree.draw.AbstractDrawOperateTree;
import com.yt.datastructure.baseModel.BTreeNode;

/**
 * @author SUN
 * @create 2019-03-26 下午11:42
 * @desc
 */
public class AVLTreeDemo extends AbstractDrawOperateTree implements AVLTree{

    public AVLTreeDemo() {
    }

    public AVLTreeDemo(BTreeNode<Integer> root) {
        this.root = root;
    }

    @Override
    public void add(Integer t) {

    }

    @Override
    public void delete(Integer t) {

    }

    @Override
    public Integer query(Integer v) {
        return null;
    }

    private int height(BTreeNode node) {
        // TODO: 2019/3/27
        return 0;
    }

    //这里权限应该是private 不用反射就直接设置了
    //由于 没有指针。。。
    public void LLRotate(BTreeNode rootParent, boolean isLeft) {
        BTreeNode curRoot = null;
        if (rootParent == null) {
            curRoot = root;
        } else {
            curRoot = isLeft ? rootParent.left : rootParent.right;
        }

        BTreeNode tmp = curRoot.left;
        curRoot.left = curRoot.left.right;
        tmp.right = curRoot;
        if (rootParent == null) {
            root = tmp;
        } else if(isLeft) {
            rootParent.left = tmp;
        } else {
            rootParent.right = tmp;
        }
    }

    /**
     6
     3                                       7
     2                   5                   null                null
     null      null      4         null      null      null      null      null
     * @param rootParent
     * @param isLeft
     */
    public void RRRotate(BTreeNode rootParent, boolean isLeft) {
        BTreeNode curRoot = null;
        if (rootParent == null) {
            curRoot = root;
        } else {
            curRoot = isLeft ? rootParent.left : rootParent.right;
        }

        BTreeNode tmp = curRoot.right;
        curRoot.right = curRoot.right.left;
        tmp.left = curRoot;
        if (rootParent == null) {
            root = tmp;
        } else if(isLeft) {
            rootParent.left = tmp;
        } else {
            rootParent.right = tmp;
        }
    }

    public void LRRotate(BTreeNode rootParent, boolean isLeft) {
        if (rootParent == null) {
            RRRotate(root, true);
            LLRotate(null, true);
        } else {
            RRRotate(isLeft ? rootParent.left : rootParent.right, true);
            LLRotate(rootParent, isLeft);
        }
    }

    public void RLRotate(BTreeNode rootParent, boolean isLeft) {
        if (rootParent == null) {
            LLRotate(root, false);
            RRRotate(null, true);
        } else {
            LLRotate(isLeft ? rootParent.left : rootParent.right, true);
            RRRotate(rootParent, isLeft);
        }
    }
}
