package com.yt.redis.theroy.model.link;

/**
 * Created by yantong on 2019/4/3.
 *
 * 双端队列
 */
public class RedisList {

    private RedisListNode head;

    private RedisListNode tail;

    private long len;

    public RedisListNode getHead() {
        return head;
    }

    public void setHead(RedisListNode head) {
        this.head = head;
    }

    public RedisListNode getTail() {
        return tail;
    }

    public void setTail(RedisListNode tail) {
        this.tail = tail;
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }
}
