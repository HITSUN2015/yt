package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import com.yt.solutions.link.RemoveDuplicatesFromSortedListII;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void testSolution() {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        ListNode head = ListNode.build("1,2,2,3");
        solution.deleteDuplicates(head);
    }
}
