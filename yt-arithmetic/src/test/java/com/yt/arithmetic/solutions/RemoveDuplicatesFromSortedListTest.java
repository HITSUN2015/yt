package com.yt.arithmetic.solutions;

import com.yt.arithmetic.solutions.help.ListNode;
import com.yt.arithmetic.solutions.link.RemoveDuplicatesFromSortedList;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void solution() {

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        ListNode head = ListNode.build("4,3,3");

        solution.deleteDuplicates(head);
    }
}
