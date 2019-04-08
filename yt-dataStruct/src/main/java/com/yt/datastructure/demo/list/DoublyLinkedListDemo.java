package com.yt.datastructure.demo.list;

import com.yt.datastructure.base.list.DoublyLinkedList;
import com.yt.datastructure.baseModel.DoublyLinkedNode;

/**
 * Created by yantong on 2019/4/8.
 */
public class DoublyLinkedListDemo<T> implements DoublyLinkedList{
    private DoublyLinkedNode<T> head;

    private DoublyLinkedNode<T> tail;

    private long len;

    public DoublyLinkedNode<T> getHead() {
        return head;
    }

    public void setHead(DoublyLinkedNode<T> head) {
        this.head = head;
    }

    public DoublyLinkedNode<T> getTail() {
        return tail;
    }

    public void setTail(DoublyLinkedNode<T> tail) {
        this.tail = tail;
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }
}
