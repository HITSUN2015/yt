package com.yt.solutions.help;/**
 * Created by SUN on 19/3/19.
 */

/**
 * @author SUN
 * @create 2019-03-19 下午10:52
 * @desc
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
