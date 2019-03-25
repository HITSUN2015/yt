package com.yt.datastructure.datastructure.jvm.memory;/**
 * Created by SUN on 18/3/14.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2018-03-14 下午8:14
 * @desc java堆溢出OOMdemo
 */
public class OOMByHeap {
    static class OOMObject {
    }

    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=[location]
     * @param args
     */
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
