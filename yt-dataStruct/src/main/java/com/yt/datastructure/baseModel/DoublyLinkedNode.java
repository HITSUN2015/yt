package com.yt.datastructure.baseModel;

/**
 * Created by yantong on 2019/4/8.
 */
public class DoublyLinkedNode<T> {

    private T value;
    private DoublyLinkedNode<T> pre;
    private DoublyLinkedNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedNode<T> getPre() {
        return pre;
    }

    public void setPre(DoublyLinkedNode<T> pre) {
        this.pre = pre;
    }

    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }
}
