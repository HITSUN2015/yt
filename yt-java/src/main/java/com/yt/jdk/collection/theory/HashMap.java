package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.jdk.collection.theory.datastruct.单链表;
import com.yt.jdk.collection.theory.datastruct.哈希表;
import com.yt.jdk.collection.theory.datastruct.红黑树;
import com.yt.jdk.collection.theory.tread.FailFast机制;

/**
 * @author SUN
 * @create 2018-03-20 下午4:04
 * @desc
 */
public class HashMap implements 哈希表,单链表,红黑树,FailFast机制 {

    /**
     * Fields:
     *      Node<K,V>[] table 哈希表中存储了多个链
     *              1>当单个链中元素超过 TREEIFY_THRESHOLD = 8时,该链转换成红黑树;
     *      Set<Map.Entry<K,V>> entrySet
     *      size:
     *             1>.DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
     *             2>.二倍扩容
     *                  1>the elements from each bin must either stay at same index,
     *                    or move with a power of two offset in the new table
     *      modCount
     *      threshold
     *      loadFactor:
     *              1>.0.75f
     *
     * 这个类还需要看TODO http://blog.csdn.net/u010498696/article/details/45888613
     */
}
