package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.SinglyLinkedList;
import com.yt.jdk.collection.theory.tread.FailFast机制;
import com.yt.jdk.collection.theory.tread.Sync关键字;

/**
 * @author SUN
 * @create 2018-03-20 下午4:56
 * @desc
 */
public class HashTable implements com.yt.datastructure.HashTable,SinglyLinkedList,Sync关键字,FailFast机制 {

    /**
     * 1.在桶的插入时,插入到head节点
     *          Entry<K,V> e = (Entry<K,V>) tab[index];
     *          tab[index] = new Entry<>(hash, key, value, e);
     *          protected Entry(int hash, K key, V value, Entry<K,V> next)
     * 2.扩容:int newCapacity = (oldCapacity << 1) + 1;
     *       直到 MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
     */
}
