package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.DoublyLinkedList;

/**
 * @author SUN
 * @create 2018-03-20 下午5:20
 * @desc
 */
public abstract class LinkedHashMap extends HashMap implements DoublyLinkedList {
    /**
     * 主要需求是 主要需求是是否需要按插入顺序，进行遍历
     *          所以在 HashMap基础上，用双链表维护了所有节点的先后顺序
     */
}
