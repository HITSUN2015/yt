package com.yt.collection.experience.create;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-13 下午3:11
 * @desc 这个类只是用来 演示代码
 */
@Deprecated
public class ListCreate {

    public static List createWithGuava() {
        return Lists.newArrayList();
//        Sets.newHashSet();
//        Maps.newHashMap();
    }

    public static List createWithNew() {
        return new ArrayList<>();
//        new HashSet();
//        new HashMap();
    }

    /**
     * 用于返回空list,但是不用new对象
     *
     * 修改该返回值会抛出 UnsupportedOperationException
     * @return
     */
    public static List createWithCollections1() {
        return Collections.EMPTY_LIST;
//        Collections.EMPTY_SET;
//        Collections.EMPTY_MAP;
    }

    /**
     * 用于返回空list,但是不用new对象 支持泛型
     */
    public static List createWithCollections2() {
        return Collections.emptyList();
//        Collections.emptySet();
//        Collections.emptyMap();
    }

}
