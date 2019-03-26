package com.yt.datastructure.datastruct;

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
            case LINK:
                return new Link();
            default:
                return null;
        }
    }
}
