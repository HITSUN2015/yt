package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import com.yt.solutions.link.ReverseLinkedList;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedListTest {

    @Test
    public void testSolution() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = ListNode.build("4,3");
        reverseLinkedList.reverseList(head);


    }
}
