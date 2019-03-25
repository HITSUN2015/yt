package com.yt.datastructure.datastructure.lamda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/1/7.
 */
public class Learning {

    /**
     * 这里 写个 总结
     * 1.stream相关的对象；
     *      Predicate
     *      collect(Collectors.joining(", "));这里好像有挺多可以扩展的用例
     * 2.每个对象支持的方法：
     * 3.对象之间互相转换的方式：
     */
    public void listOperation() {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.stream().filter(x -> x.equals("test")).findFirst();

    }

    public void testInterfaceConstruct() {
        FuncationalInterfaceTest funcationalInterfaceTest = () -> 1;
    }



}
