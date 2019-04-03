package com.yt.redis.theroy.model.dict;

/**
 * Created by yantong on 2019/4/3.
 */
public class DictEntry {

    private Object key;

    private Object v;   //c中的union联合体：一个多个变量的结构同时使用一块内存区域
                        //可以是 指针,unit64_t,int64_t


    //hash collision,新入节点插入表头，实现与JDK.HashTable一样
    private DictEntry next;
}
