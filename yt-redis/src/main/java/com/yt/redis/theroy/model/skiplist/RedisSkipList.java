package com.yt.redis.theroy.model.skiplist;

/**
 * Created by yantong on 2019/4/8.
 *
 * {@link com.yt.datastructure.base.list.SkipList}
 *
 * RedisSkipList 是一种，向前是普通单步指针，向后支持多步（层）
 *
 *      {@link ZSkipListNode#score}
 *      用来排序，所有节点按从小到大排序,
 *      分值可以相同，但{@link ZSkipListNode#obj}应该不同
 *
 *      这里为了提供更具效率的其他api，所以建立了 {@link ZSkipListDemo}
 *
 *      遍历操作值需要用到{@link ZSkipLevel#forward}，
 *      {@link ZSkipLevel#span}是用来计算排位的
 */
public interface RedisSkipList {
}
