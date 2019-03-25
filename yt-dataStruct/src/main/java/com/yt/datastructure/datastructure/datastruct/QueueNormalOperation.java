package com.yt.datastructure.datastructure.datastruct;

/**
 * Created by yantong on 2019/2/14.
 */
public interface QueueNormalOperation<T> extends DataStructure {

    void enqueue(T t);

    T dequeue();

    //可能还有判空
}
