package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import com.yt.solutions.link.ReverseLinkedListII;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedListIITest {

    @Test
    public void testReverseLinkedListII() {
        ReverseLinkedListII solution = new ReverseLinkedListII();

        ListNode head = ListNode.build("3,5");

        solution.reverseBetween(head, 1, 2);
    }
}
