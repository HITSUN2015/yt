package com.yt.datastructure.solutions;

import com.yt.datastructure.solutions.help.ListNode;
import com.yt.datastructure.solutions.link.RotateList;
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
