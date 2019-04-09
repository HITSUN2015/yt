package com.yt.interview.tou;/**
 * Created by SUN on 19/3/25.
 */

/**
 * @author SUN
 * @create 2019-03-25 下午8:11
 * @desc
 */
public class Solution {

    //链表大数加法 
//        2->3->5  : 235
    // 4->2->6 
    //  => 6->6->1 :  数字较大，会超过 64 位整数的表示范围  */ //

    //O(n)


    public static Node add(Node v1, Node v2) {
        if (null == v1) {
            return v2;
        }
        if (null == v2) {
            return v1;
        }

        Node v1Head = revert(v1);//这个方法 返回length 更好
        Node v2Head = revert(v2);

        Node v1Index = v1Head;
        Node v2Index = v2Head;

        Node pre = null;
        int carry = 0;
        while (null != v1Index) {
            int curSum = 0;
            if (v2Index != null) {
                curSum = v1Index.value + v2Index.value + carry;
                v2Index = v2Index.next;
            } else if (carry == 1) {
                curSum = v1Index.value + carry;
            } else {
                curSum = v1Index.value;
            }
            v1Index.value = curSum % 10;
            if (v1Index.next == null) {
                pre = v1Index;
            }
            carry = curSum / 10;
            v1Index = v1Index.next;

        }

        if (null != v2Index) {
            v1Index.next = v2Index;
        }

        while (null != v2Index) {
            // TODO: 19/3/25 merge code
            int curSum = v2Index.value + carry;
            v2Index.value = curSum % 10;
            v2Index = v2Index.next;
            carry = curSum / 10;
            if (v2Index.next == null) {
                pre = v1Index;
            }
        }

        if (carry == 1) {
            pre.next = new Node();
            pre.next.value = 1;
        }

        return revert(v1Head);
    }

    //倒转
    private static Node revert(Node v1) {
        Node pre = null;
        Node index = v1;
        while (index != null) {
            Node tmp = index.next;
            index.next = pre;
            pre = index;
            index = tmp;
        }
        return pre;
    }


    // 2->3->5 ->6 : 235
    //    4->2->6 
    // 2782
    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node12 = new Node(3);
        Node node13 = new Node(5);
        Node node14 = new Node(6);
        node1.next = node12;
        node12.next = node13;
        node13.next = node14;

        Node node20 = new Node(4);
        Node node21 = new Node(2);
        Node node22 = new Node(6);
        node20.next = node21;
        node21.next = node22;

        Node result = add(node20,node1);
        System.out.println();
    }
}
