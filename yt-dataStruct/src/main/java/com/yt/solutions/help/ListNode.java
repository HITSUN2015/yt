package com.yt.solutions.help;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by yantong on 2019/3/19.
 */
//Definition for singly-linked list.
public class ListNode implements Iterable<ListNode> {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode build(String nodeString) {
        if (null == nodeString || nodeString.isEmpty()) {
            return null;
        }
        String[] nodes = nodeString.split(",");
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode index = pre;
        for (int i = 0; i < nodes.length; i++) {
            ListNode curNode = new ListNode(Integer.parseInt(nodes[i]));
            index.next = curNode;
            index = index.next;
        }
        return pre.next;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return next != null ? true : false;
            }

            @Override
            public Object next() {
                return next;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
