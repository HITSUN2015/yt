package com.yt.jdk.collection.theory;/**
 * Created by SUN on 18/3/20.
 */

import com.yt.datastructure.HashTable;
import com.yt.datastructure.base.tree.RedBlackTree;
import com.yt.datastructure.base.list.SinglyLinkedList;
import com.yt.jdk.collection.theory.tread.FailFast机制;

import java.util.HashMap;

/**
 * @author SUN
 * @create 2018-03-20 下午4:04
 * Created by yantong on 2019/4/2. 改版
 *
 * 数据结构：
 *  元数据： {@link HashMap.Node}
 *           {@link HashMap.Node#hash}    key的hash值
 *           {@link HashMap.Node#key}     key对象
 *           {@link HashMap.Node#value}   value对象
 *           {@link HashMap.Node#next}    起初落入同一个桶内的元素，做链表
 *  集合属性：{@link HashMap}
 *       {@link HashMap#table}      上述数据结构的数组，用来装在Map的实际key-value
 *       {@link HashMap#entrySet}   // TODO: 2019/4/2 查看 HashMap是如何维护EntrySet的
 *       {@link HashMap#size}       集合中元素个数
 *       {@link HashMap#threshold}  扩容的临街值，一般等于 容量 * {@link HashMap#loadFactor}
 *       {@link HashMap#loadFactor} 用于计算{@link HashMap#threshold}：实际拥有的数据量，占{@link HashMap#table} 数组的最大值
 *       {@link HashMap#modCount}   这个字段比较通用，最好的解释见于：{@link java.util.AbstractList#modCount}
 *                                      个人理解：为了让Iterator遍历时，更快的知道当前数据的变更，更快的返回失败，
 *                                      每插入一个元素 modCount++ // TODO: 2019/4/2 为什么不用size
 * 扩容：{@link HashMap#resize()} 触发时间：{@link HashMap#size} > {@link HashMap#threshold}
 *                                扩容的算法：TODO 再找时间读下 hashMap的扩容
 * 冲突解决：{@link HashMap#putVal(int, Object, Object, boolean, boolean)}
 *                  桶的选择：index = ({@link HashMap#table}.length - 1) & {@link Object#hashCode()} 实际就是hash值的低n位
 *                  冲突：桶内达到{@link HashMap#TREEIFY_THRESHOLD}个，则将这个link转换为tree // TODO: 2019/4/2 再找时间读下节点插入， 与 树的转换
 *
 */
public class JDKHashMap implements HashTable,SinglyLinkedList,RedBlackTree,FailFast机制 {

}
