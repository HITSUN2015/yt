package com.yt.datastruct;

/**
 * Created by yantong on 2019/2/14.
 */
public class DataStructureFactory {

    public static DataStructure getDataStructure(DataStructureEnum dataStructureEnum) {
        switch (dataStructureEnum) {
            case ARRAY:
                return new Array();
            case STACK:
                return new Stack();
            case QUEUE:
                return new Queue();
            default:
                return null;
        }
    }
}
