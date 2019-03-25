package com.yt.datastructure.datastructure.solutions.link;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.ListNode;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedListII implements LeetCode {
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

    //这个 写法 还是 太 蛋疼 不够简单
    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultHeader = null;
        ListNode resultPre = null;

        ListNode index = head;
        while (index != null) {
            int curValue = index.val;
            boolean toDrop = index.next == null ? false : (curValue == index.next.val);

            if (toDrop) {
                while (index != null && curValue == index.val) {
                    index = index.next;
                }
                //这里 第二次 漏掉了
                if (resultPre != null) {
                    resultPre.next = index;
                }
            } else {
                if (resultHeader == null) {
                    resultHeader = index;
                    resultPre = index;
                } else {
                    resultPre.next = index;
                    resultPre = index;
                }
            }

            //这里第一次变成 漏掉了
            if (index != null && !toDrop) {
                index = index.next;
            }
        }
        return resultHeader;
    }
}
