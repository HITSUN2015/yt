package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.
 */
public enum DataStructureEnum {
    ARRAY("数组"),
    STACK("栈"),
    QUEUE("队列"),
    LINK("链表")
    ;
    private String name;

    DataStructureEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
