package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.HashTable;
import com.yt.datastructure.base.list.SinglyLinkedList;
import com.yt.jdk.collection.theory.tread.FailFast机制;
import com.yt.jdk.collection.theory.tread.Sync关键字;

/**
 * @author SUN
 * @create 2018-03-20 下午4:56
 * @desc {@link java.util.Hashtable}
 *
 * 数据结构：
 *  元数据：{@link java.util.Hashtable#entrySet}
 *  集合：  {@link java.util.Hashtable#table}
 *
 * 实现近似于{@link java.util.HashMap}，讲解见{@link JDKHashMap}
 *
 * index:(hash & 0x7FFFFFFF) % tab.length
 *
 * 扩容：2倍    TODO hashTable的扩容
 *
 * 桶冲突：{@link java.util.Hashtable#table} 存储的是每个桶的header
 *         而插入新节点时，newHeader.next = table[index];
 *                         table[index] = newHeader;
 *
 * 线程安全：TODO hashtable的线程安全实现
 */
public class JDKHashTable implements HashTable,SinglyLinkedList,Sync关键字,FailFast机制 {

}
