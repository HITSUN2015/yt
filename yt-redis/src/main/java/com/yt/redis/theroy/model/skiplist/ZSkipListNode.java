package com.yt.redis.theroy.model.skiplist;

/**
 * Created by yantong on 2019/4/8.
 */
public class ZSkipListNode {

    private ZSkipListNode backward;

    private double score;

    private String obj;

    private ZSkipLevel[] levels;
}
