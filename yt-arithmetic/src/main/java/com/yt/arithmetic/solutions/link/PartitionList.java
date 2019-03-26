package com.yt.arithmetic.solutions.link;

import com.yt.arithmetic.leetcode.LeetCode;
import com.yt.arithmetic.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 */
public class PartitionList implements LeetCode {


    @Override
    public int getProblemNumber() {
        return 86;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public ListNode partition(ListNode head, int x) {
        //方法：把大于等于x的分离出来
        //最后把分离出来的 接在原有的 尾部
        //第一遍 写完了 逻辑不够清晰 有bug

        ListNode pre = null;
        ListNode index = head;

        ListNode bigHead = null;
        ListNode bigPre = null;

        ListNode smallHead = null;
        ListNode smallPre = null;

        //两条支路不一样 整不明白了
        while (index != null) {
            ListNode next = index.next;
            if (index.val < x) {
                if (smallHead == null) {
                    smallHead = index;
                }
                if (smallPre == null) {
                    smallPre = index;
                } else {
                    smallPre.next = index;
                    smallPre = index;
                }
            } else {
                if (bigHead == null) {
                    bigHead = index;
                }
                if (bigPre == null) {
                    bigPre = index;
                } else {
                    bigPre.next = index;
                    bigPre = index;
                }
            }
            index.next = null;
            index = next;
        }

        if (null == smallHead) {
            return bigHead;
        } else {
            smallPre.next = bigHead;
            return smallHead;
        }
    }
}
