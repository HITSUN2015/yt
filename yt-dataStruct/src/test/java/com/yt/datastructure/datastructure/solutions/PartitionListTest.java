package com.yt.datastructure.datastructure.solutions;

import com.yt.datastructure.datastructure.solutions.help.ListNode;
import com.yt.datastructure.datastructure.solutions.link.PartitionList;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/19.
 */
public class PartitionListTest {

    @Test
    public void testSolution() {

        ListNode header = ListNode.build("1,4,3,2,5,2");

        PartitionList solution = new PartitionList();
        solution.partition(header, 3);
    }
}
