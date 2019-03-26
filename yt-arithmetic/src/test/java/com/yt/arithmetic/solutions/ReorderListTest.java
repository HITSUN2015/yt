package com.yt.arithmetic.solutions;

import com.yt.arithmetic.solutions.help.ListNode;
import com.yt.arithmetic.solutions.link.ReorderList;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/20.
 */
public class ReorderListTest {

    @Test
    public void testSolution() {
        ReorderList solution = new ReorderList();
//        ListNode head = ListNode.build("1,2,3,4,5");
//        ListNode head = ListNode.build("1,2");
//        ListNode head = ListNode.build("1");
        ListNode head = null;
        solution.reorderList(head);
    }
}
