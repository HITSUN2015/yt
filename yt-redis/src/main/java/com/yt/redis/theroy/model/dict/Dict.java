package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 */
public class Dict {

    private DictType type;

    private Object privdata;

    private Dictht[] dictht;//size = 2 dictht[1]只是对dictht[0]rehash时使用

    private int trehashidx;

}
