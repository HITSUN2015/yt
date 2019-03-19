package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void solution() {

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);

        solution.deleteDuplicates(head);
    }
}
