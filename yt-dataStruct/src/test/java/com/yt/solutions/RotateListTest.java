package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RotateListTest {

    @Test
    public void testSolution() {
        RotateList solution = new RotateList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        solution.rotateRight(head, 2);
    }
}
