package com.yt.datastructure.baseModel;

/**
 * Created by yantong on 2019/2/14.
 */
public class LinkNode<T> {

    private T value;
    private LinkNode next;

    public LinkNode(T value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
