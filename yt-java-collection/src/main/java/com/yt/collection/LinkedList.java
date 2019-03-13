package com.yt.collection;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.collection.datastruct.双向链表;
import com.yt.collection.tread.FailFast机制;

/**
 * @author SUN
 * @create 2018-03-20 下午3:20
 * @desc
 *      基于基本的链表的增删改
 *      其中根据index插入时,会判断index属于前半段还是后半段,也就是实际的插入动作:遍历小于n/2个元素
 */
public class LinkedList implements 双向链表,FailFast机制 {
}
