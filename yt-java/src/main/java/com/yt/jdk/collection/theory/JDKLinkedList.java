package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.base.list.DoublyLinkedList;
import com.yt.jdk.collection.theory.tread.FailFast机制;

/**
 * @author SUN
 * @create 2018-03-20 下午3:20
 * @desc
 *      基于基本的链表的增删改
 *      其中根据index插入时,会判断index属于前半段还是后半段,也就是实际的插入动作:遍历小于n/2个元素
 */
public class JDKLinkedList implements DoublyLinkedList,FailFast机制 {
}
