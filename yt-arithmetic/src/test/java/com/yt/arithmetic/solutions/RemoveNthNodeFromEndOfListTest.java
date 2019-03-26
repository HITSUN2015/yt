package com.yt.arithmetic.solutions;/**
 * Created by SUN on 19/3/19.
 */

import com.yt.arithmetic.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-19 下午8:03
 * @desc
 */
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void testSolution() {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        solution.removeNthFromEnd(head, 2);
    }
}
