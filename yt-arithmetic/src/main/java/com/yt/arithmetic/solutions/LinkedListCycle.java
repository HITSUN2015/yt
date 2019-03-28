package com.yt.arithmetic.solutions;/**
 * Created by SUN on 19/3/19.
 */


import com.yt.arithmetic.leetcode.LeetCode;
import com.yt.demo.helper.util.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SUN
 * @create 2019-03-19 下午11:18
 * @desc
 */
public class LinkedListCycle implements LeetCode {


    @Override
    public int getProblemNumber() {
        return 141;
    }

    @Override
    public String performResult() {
        return null;
    }

    @Override
    public long getSoluteTime() {
        return 0;
    }

    public boolean hasCycle(ListNode head) {
        //use hash 总感觉这么做,不是正规解法那。。。
        //方法二:给node加字段。。。
        //方法三: 让一个点跑500个节点,停,再让第二个点跑500 看能不能遇见之前的节点。再想了想 可以跑n个
        Set<ListNode> flags = new HashSet<>();
        int distance = 10;
        int curDistance = 0;

        while (true) {
            distance *= 2;
            ListNode index = head;
            while (index != null && curDistance <= distance) {
                curDistance++;
                index = index.next;
                if (flags.contains(index)) {
                    return true;
                }
            }
            if (index == null) {
                return false;
            }
            flags.add(index);
        }
    }
}
