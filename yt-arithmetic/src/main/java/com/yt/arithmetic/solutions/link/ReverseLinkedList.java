package com.yt.arithmetic.solutions.link;

import com.yt.arithmetic.leetcode.LeetCode;
import com.yt.arithmetic.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedList implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 206;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public ListNode reverseList(ListNode head) {
        ListNode indexNode = head;
        ListNode preNode = null;
        while (indexNode != null) {
            //改变当前node.element
            //empty

            ListNode nextNode = indexNode.next;

            //改变当前node.link
            indexNode.next = preNode;

            //移动indexNode
            preNode = indexNode;
            indexNode = nextNode;
        }

        return preNode;
    }
}
