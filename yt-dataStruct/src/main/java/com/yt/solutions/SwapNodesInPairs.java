package com.yt.solutions;/**
 * Created by SUN on 19/3/19.
 */

import com.yt.leetcode.LeetCode;
import com.yt.solutions.help.ListNode;

/**
 * @author SUN
 * @create 2019-03-19 下午10:12
 * @desc
 */
public class SwapNodesInPairs implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 24;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public ListNode swapPairs(ListNode head) {
        //     node    ->  node -> node
        //pre  second      first

        //这回题目又输入空了。。。还是养成 每次都判空吧
        ListNode first = head == null ? null : head.next;
        ListNode second = head;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = second;
        while (first != null) {
            pre.next = first;
            second.next = first.next;
            first.next = second;
            // TODO: 19/3/19
            if (pre.val == Integer.MIN_VALUE) {
                head = first;
            }

            pre = second;
            second = second.next;
            //这里之前写错了 second已经被后移了一个。。。
//            first = second.next == null ? null : second.next.next;
            first = second == null ? null : second.next;
        }
        return head;
    }
}
