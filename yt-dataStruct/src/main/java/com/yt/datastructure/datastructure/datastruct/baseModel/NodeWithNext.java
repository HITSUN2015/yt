package com.yt.datastructure.datastructure.datastruct.baseModel;

/**
 * Created by yantong on 2019/2/14.
 */
public class NodeWithNext<T> {
    private T value;
    private NodeWithNext next;

    public NodeWithNext(T value, NodeWithNext next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeWithNext getNext() {
        return next;
    }

    public void setNext(NodeWithNext next) {
        this.next = next;
    }
}
