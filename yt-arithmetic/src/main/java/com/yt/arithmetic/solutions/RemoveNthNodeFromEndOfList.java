package com.yt.arithmetic.solutions;/**
 * Created by SUN on 19/3/19.
 */


import com.yt.arithmetic.leetcode.LeetCode;
import com.yt.arithmetic.solutions.help.ListNode;

/**
 * @author SUN
 * @create 2019-03-19 下午7:59
 * @desc
 */
public class RemoveNthNodeFromEndOfList implements LeetCode {


    @Override
    public int getProblemNumber() {
        return 0;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }


    //这个我以前可能做过 上来就想到了 两个index
    //题目不会传出 n = length 额 这理解错了 题目会给length。。。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);//这里 虚拟一个pre TODO
        ListNode second = head;
        pre.next = second;
        ListNode first = head;

        // pre   second  first
        //       node

        for(int i = 1; i <= n ; i++){
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            pre = second;
            second = second.next;
        }

        if (pre.val == Integer.MIN_VALUE) {
            return head.next;
        }

        pre.next = pre.next.next;
        return head;
    }


}
