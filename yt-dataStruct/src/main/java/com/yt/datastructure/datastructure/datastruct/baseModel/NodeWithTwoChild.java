package com.yt.datastructure.datastructure.datastruct.baseModel;

/**
 * Created by yantong on 2019/2/14.
 */
public class NodeWithTwoChild<T> {
    private T value;
    private NodeWithTwoChild leftChild;
    private NodeWithTwoChild rightChild;

    public NodeWithTwoChild(T value, NodeWithTwoChild leftChild, NodeWithTwoChild rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeWithTwoChild getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeWithTwoChild leftChild) {
        this.leftChild = leftChild;
    }

    public NodeWithTwoChild getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeWithTwoChild rightChild) {
        this.rightChild = rightChild;
    }
}
