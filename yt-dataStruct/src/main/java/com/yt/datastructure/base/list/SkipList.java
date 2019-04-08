package com.yt.datastructure.base.list;

/**
 * Created by yantong on 2019/3/26.
 *
 * 查找：平均O(logN) 最坏O(N)
 * 支持通过顺序性操作来批量处理节点
 *
 * 个人理解：是一种特殊的DoublyLinkedList
 *      他的向前或向后的指针，支持能跳过多个节点，这个功能在skiplist里，
 *      通过 层 这个概念实现
 *      如果只有一层，则退化为：普通的pre pointer，next pointer
 *      如果多层：pointer[]
 *
 * // TODO: 2019/4/8 实现
 *
 * TODO《Skip Lists:A Probabilistic Alternative to Balanced Trees》
 */
public interface SkipList extends Link {

}
