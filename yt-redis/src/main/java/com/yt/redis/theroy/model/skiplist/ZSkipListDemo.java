package com.yt.redis.theroy.model.skiplist;

import com.yt.datastructure.base.list.SkipList;

/**
 * Created by yantong on 2019/4/8.
 *
 * todo 实现redis 跳表
 */
public class ZSkipListDemo implements SkipList {

    private ZSkipListNode header;

    private ZSkipListNode tail;

    private long length;            //unsigned 表中节点的数量 表头节点不算

    int level;                      //表中层数最大的节点的层数 不算表头
}
