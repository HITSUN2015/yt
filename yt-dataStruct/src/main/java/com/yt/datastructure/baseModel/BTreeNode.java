package com.yt.datastructure.baseModel;

/**
 * Created by yantong on 2019/2/14.
 */
public class BTreeNode<T> {

    //用于演示 放开封装

    public T value;
    public BTreeNode left;
    public BTreeNode right;

    public BTreeNode(T value) {
        this.value = value;
    }

    public BTreeNode(T value, BTreeNode left, BTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
