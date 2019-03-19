package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class PartitionListTest {

    @Test
    public void testSolution() {

        ListNode header = new ListNode(1);
        header.next = new ListNode(4);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(2);
        header.next.next.next.next = new ListNode(5);
        header.next.next.next.next.next = new ListNode(2);

        PartitionList solution = new PartitionList();
        solution.partition(header, 3);
    }
}
