package com.yt.datastructure.datastructure.solutions.link;

import com.yt.datastructure.datastructure.leetcode.LeetCode;
import com.yt.datastructure.datastructure.solutions.help.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedList implements LeetCode {
    @Override
    public int getProblemNumber() {
        return 83;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> existed = new HashSet<>();

        ListNode index = head;
        ListNode pre = null;

        while (index != null) {
            ListNode next = index.next;

            if (existed.contains(index.val)) {
                pre.next = next;
            } else {
                pre = index;
                existed.add(index.val);
            }

            index = next;
        }
        return head;
    }
}
