package com.yt.collection.experience;/**
 * Created by SUN on 19/3/13.
 */

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-13 下午6:52
 * @desc
 */
public class Delete {

    public void iteratorDelete() {
        List list = Lists.newArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }

    /**
     * 实际也是 调用了 Iterator
     */
    public static void removeIf() {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        list.removeIf(x -> x > 3);
    }
}
