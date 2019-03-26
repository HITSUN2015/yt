package com.yt.datastructure;

/**
 * Created by yantong on 2019/2/14.
 */
public interface Queue<T> extends DataStruct {

    void enqueue(T t);

    T dequeue();

    //可能还有判空
}
