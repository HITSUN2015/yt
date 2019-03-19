package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedListTest {

    @Test
    public void testSolution() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode header = new ListNode(4);
        header.next = new ListNode(3);
        reverseLinkedList.reverseList(header);


    }
}
