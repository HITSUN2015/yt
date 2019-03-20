package com.yt.solutions.link;

import com.yt.leetcode.LeetCode;
import com.yt.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/20.
 */
public class ReorderList implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 143;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    //这个方法 跑出来 确实比较慢。。。
    public void reorderList(ListNode head) {
        //方法1：把这个link 改成 array
        //方法2：把node再包一层，做个 双向链，然后头尾开始遍历
        //方法3：选完第一个点，就遍历到尾，搬过来，再找下一个。。。。空间少 循环多。。。

        //感觉都不是好方法

        ListNode index = head;
        while (index != null) {

            if (index.next == null) {
                break;
            }

            //find tail and tailPre
            ListNode tailIndex = head;
            ListNode tailPre = new ListNode(Integer.MIN_VALUE);
            tailPre.next = tailIndex;
            while (tailIndex.next != null) {
                tailPre = tailIndex;
                tailIndex = tailIndex.next;
            }

            tailPre.next = null;

            ListNode next = index.next;
            index.next = tailIndex;
            tailIndex.next = next;
            index = next;
        }
        System.out.println(head);
    }

}
