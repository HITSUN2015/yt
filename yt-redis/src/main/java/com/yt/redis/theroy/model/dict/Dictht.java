package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 * hashtable
 */
public class Dictht {

    private DictEntry[] table;
    private long size;      //unsigned
    private long sizeMark;  //unsigned TODO: 2019/4/3
    private long used;      //unsigned 实际节点个数

}
