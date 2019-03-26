package com.yt.arithmetic.solutions;/**
 * Created by SUN on 19/3/19.
 */

import com.yt.arithmetic.solutions.help.ListNode;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-19 下午10:14
 * @desc
 */
public class SwapNodesInPairsTest {
    @Test
    public void testSolution() {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        ListNode head = new ListNode(1);
        solution.swapPairs(head);
    }
}
