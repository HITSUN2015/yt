package com.yt.coding.method.base.model;

/**
 * Created by yantong on 2019/4/17.
 */
public enum ParamType {
    ONLY_READ,
    WRITE_ONE_TIME,
    WRITE_MORE_THAN_ONE_TIME,
    COLLECT_RETURN,//类似i = i + 表达式 eg:累加、字符串接合、写入流、集合添加
    FOR_LOOP
    ;
}
