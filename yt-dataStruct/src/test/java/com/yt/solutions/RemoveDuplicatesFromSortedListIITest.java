package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void testSolution() {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        solution.deleteDuplicates(head);
    }
}
