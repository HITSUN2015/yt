package com.yt.lamda.jdk.theory;

import com.google.common.collect.Lists;
import com.yt.lamda.jdk.theory.demo.CustomerCollection;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

/**
 * Created by yantong on 2019/4/1.
 *
 * 查资料关于{@link Spliterator}的介绍 都没有那么透亮
 * 这里我先以，实现自定义集合，支持多线程stream操作未目标，看看能不能学会应用，然后再总结jdk是如何实现的
 *
 * {@link CustomerCollection}
 *
 * 多线程，分区的原理：TODO {@link StreamAPISpliterator#testLamdaParallelPartitioner()}
 *  stack比较深，有时间再分析
 */
public class StreamAPISpliterator {


    public void customerCollection() {
        Integer[] datas = new Integer[]{12, 3, 43, 4, 5, 6,};

        CustomerCollection cannotParallelForeach = new CustomerCollection();
        cannotParallelForeach.setDatas(datas);
        //.forEach(System.out::println);//没有 foreach 接口
        cannotParallelForeach.stream().parallel();

        //确定泛型
        CustomerCollection<Integer> canParallelForeach = new CustomerCollection();
        canParallelForeach.setDatas(datas);
        //多次打印顺序 不一致 TODO
        canParallelForeach.stream().parallel().forEach(System.out::println);

        List src = Lists.newArrayList();
        src.stream().parallel();//并非是自定义的 无法foreach 而是 所有未标注集合元素类型的，都不可以
    }

    public void lamdaParallelPartitioner() {
        IntStream.range(0, 500).parallel().peek((x) -> {
            System.out.println(x);
        }).forEach(x -> {});
    }
}