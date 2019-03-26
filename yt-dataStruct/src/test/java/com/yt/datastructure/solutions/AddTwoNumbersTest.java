package com.yt.datastructure.solutions;

import com.yt.datastructure.solutions.help.ListNode;
import com.yt.datastructure.solutions.link.AddTwoNumbers;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
@Test
public class AddTwoNumbersTest {

    @Test
    public void testAdd() {
        AddTwoNumbers solution = new AddTwoNumbers();
        /**
          [2,4,3]
          [5,6,4]
         */
//        ListNode listNode1 = new ListNode(2);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next = new ListNode(3);
//
//        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);

        /**
         [5]
         [5]
         */
        ListNode listNode1 = new ListNode(5);

        ListNode listNode2 = new ListNode(5);



        /**
         [0]
         [7,3]
         */
//        ListNode listNode1 = new ListNode(0);
//
//        ListNode listNode2 = new ListNode(7);
//        listNode2.next = new ListNode(3);


        ListNode result = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(result);
//        for (ListNode node : result) {
//            System.out.println(node.val + "->");
//        }

    }
}
