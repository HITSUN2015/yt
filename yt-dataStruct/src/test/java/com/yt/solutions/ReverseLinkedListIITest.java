package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class ReverseLinkedListIITest {

    @Test
    public void testReverseLinkedListII() {
        ReverseLinkedListII solution = new ReverseLinkedListII();

        ListNode header = new ListNode(3);
        header.next = new ListNode(5);

        solution.reverseBetween(header, 1, 2);
    }
}
