package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import com.yt.solutions.link.RemoveDuplicatesFromSortedList;
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
