package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.
 */
public interface StackNormalOperation<T> extends DataStructure {

    //返回值 可能包含异常结果、或者返回push进来的数据等 由各自框架定
    void push(T t);

    T pop();

    T peek();

    //可能额外的还有 查看是否空等操作
}
