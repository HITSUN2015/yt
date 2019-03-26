package com.yt.datastructure.solutions.link;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 *
 * // TODO: 19/3/19 not AC
 */
public class RotateList implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 61;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = null;
        ListNode index = head;
        ListNode newHead = head;

        int length = getLength(head);
        int realK = k % length;

        int indexCounter = 0;

        while (index != null) {
            indexCounter++;

            ListNode next = index.next;

            if (indexCounter == realK) {
                index.next = null;
                newHead = next;
            }

            if (realK != 0 && index.next == null) {
                tail = index;
            }

            index = next;
        }
        if (null != tail) {
            tail.next = null;
        }

        return newHead;
    }

    private int getLength(ListNode head) {
        int counter = 0;
        while (head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }
}
