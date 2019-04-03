package com.yt.redis.theroy.model.link;

/**
 * Created by yantong on 2019/4/3.
 */
public class RedisListNode<T> {
    private RedisListNode pre;
    private RedisListNode nex;
    private T value;

    public RedisListNode getPre() {
        return pre;
    }

    public void setPre(RedisListNode pre) {
        this.pre = pre;
    }

    public RedisListNode getNex() {
        return nex;
    }

    public void setNex(RedisListNode nex) {
        this.nex = nex;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
