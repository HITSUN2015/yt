package com.yt.collection.datastruct;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.collection.datastruct.链表;

/**
 * @author SUN
 * @create 2018-03-20 下午3:23
 * @desc
 */
public interface 双向链表 extends 链表 {


        String impl =
                "\n内部类" +
                "    private static class Node<E> {\n" +
                "        E item;\n" +
                "        Node<E> next; // 指向下一个节点\n" +
                "        Node<E> prev; //指向上一个节点\n" +
                "\n" +
                "        Node(Node<E> prev, E element, Node<E> next) {\n" +
                "            this.item = element;\n" +
                "            this.next = next;\n" +
                "            this.prev = prev;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "\n基本属性" +
                "    transient Node<E> first;\n" +
                "    transient Node<E> last;";

}
