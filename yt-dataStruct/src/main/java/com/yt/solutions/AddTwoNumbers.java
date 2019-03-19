package com.yt.solutions;

import com.yt.leetcode.LeetCode;
import com.yt.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 */
public class AddTwoNumbers implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 2;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    /**
     * 很蛋疼的解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        ListNode mainNode = l1Length >= l2Length ? l1 : l2;
        ListNode resultHeader = mainNode;
        ListNode followNode = mainNode == l1 ? l2 : l1;
        int carry = 0;
        while (null != mainNode) {
            //handle cur node
            int curSum = sumValue(mainNode, followNode, carry);
            carry = curSum > 9 ? 1 : 0;
            mainNode.val = curSum > 9 ? curSum - 10 : curSum;

            //move to next node
            //由于 肯定存在 一个比一个长，所以 只需要换一次
            //进而就有了另一种 low 但是保证对的方法：先判断长度
            mainNode = null == mainNode ? null : mainNode.next;
            followNode = null == followNode ? null : followNode.next;
        }

        //多遍历一次 比较挫
        if (carry == 1) {
            ListNode tail = resultHeader;
            while (true) {
                if (tail.next == null) {
                    tail.next = new ListNode(1);
                    break;
                }
                tail = tail.next;
            }
        }

        return resultHeader;
    }

    private int getLength(ListNode header) {
        int length = 0;
        while (header != null) {
            header = header.next;
            length++;
        }
        return length;
    }

    private int sumValue(ListNode l1, ListNode l2, int carry) {
        return carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
    }

}
