package com.yt.datastructure.solutions.link;

import com.yt.datastructure.leetcode.LeetCode;
import com.yt.datastructure.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedListII implements LeetCode {

    @Override
    public int getProblemNumber() {
        return 92;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //1 ≤ m ≤ n ≤ length of list.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode beforeM = null;
        ListNode mNode = null;

        ListNode afterN = null;
        ListNode nNode = null;

        int indexCounter = 0;

        ListNode index = head;
        ListNode pre = null;

        while (null != index) {
            indexCounter++;

            if (indexCounter < m) {
                if (indexCounter == m - 1) {
                    beforeM = index;
                }
                pre = index;
                index = index.next;
            } else if (indexCounter >= m && indexCounter <= n) {
                if (indexCounter == m) {
                    mNode = index;
                }
                if (indexCounter == n) {
                    nNode = index;
                }
                ListNode nextNode = index.next;
                index.next = pre;
                pre = index;
                index = nextNode;
            } else {
                if (indexCounter == n + 1) {
                    afterN = index;
                }
                break;
            }
        }

        //fix link
        if (null != beforeM) {
            beforeM.next = nNode;
        } else {
            head = nNode;
        }
        if (null != mNode) {
            mNode.next = afterN;
        } else {
            //不可能
        }
        return head;
    }

}
