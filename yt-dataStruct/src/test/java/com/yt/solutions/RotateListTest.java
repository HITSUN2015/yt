package com.yt.solutions;

import com.yt.solutions.help.ListNode;
import com.yt.solutions.link.RotateList;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class RotateListTest {

    @Test
    public void testSolution() {
        RotateList solution = new RotateList();
        ListNode head = ListNode.build("1,2,3,4,5");

        solution.rotateRight(head, 2);
    }
}
