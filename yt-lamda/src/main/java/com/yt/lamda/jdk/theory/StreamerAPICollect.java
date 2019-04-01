package com.yt.lamda.jdk.theory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yt.lamda.jdk.theory.demo.CustomerCollector;
import com.yt.lamda.jdk.theory.demo.People;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yantong on 2019/4/1.
 *
 * 所有方法 均 未检查null
 *
 * todo Test
 */
public class StreamerAPICollect {

    /**
     * --------------------------------------------------------------
     * interfaces
     * --------------------------------------------------------------
     */

    /**
     * {@link Stream#collect(Collector)}
     *      Collector是一个接口，但并不是函数式接口
     *      这个接口在jdk 里只有 {@link Collectors}实现过
     *      自定义实现:{@link CustomerCollector}
     * {@link Stream#collect(Supplier, BiConsumer, BiConsumer)}
     * todo
     */
    public void collect() {
        List list = Lists.newArrayList();
        list.stream().collect(CustomerCollector.of());


    }

    /**
     * {@link java.util.stream.Collector}
     * // TODO: 2019/4/1
     */
    public void collector() {

    }

    /**
     * {@link Collectors}
     * // TODO: 2019/4/1
     */
    public void collectors() {

    }

    /**
     * --------------------------------------------------------------
     * demos
     *
     * List
     * Map
     * Set
     *
     * List<Map>
     * List<Set>
     *
     * Set<Map>
     * Set<List>
     *
     * Map<String,List>
     * Map<String,Set>
     * --------------------------------------------------------------
     */

    public Set<Integer> objectPropertyCollection(List<People> list) {
//        return Sets.newHashSet(list);
        return list.stream().map(People::getAge).collect(Collectors.toSet());
    }

    public Set<People> list2Set(List<People> list) {
//        return Sets.newHashSet(list);
        return list.stream().collect(Collectors.toSet());
    }

    /**
     * {@link Collectors#toMap(Function, Function, BinaryOperator, Supplier)}
     * function1:keyMapper             提供key
     * function2:valueMapper           提供value
     * BinaryOperator:mergeFunction    提供新旧值，选新的还是旧的
     * Supplier:mapSupplier            提供Map的构造函数
     */
    public Map<Integer, People> list2Map(List<People> list) {
//        return list.stream().collect(Collectors.toMap(People::getAge, x -> x));
        return list.stream().collect(Collectors.toMap(People::getAge, x -> x, (x, y) -> x, HashMap::new));
    }

    public List<People> set2List(Set<People> set) {
//        return Lists.newArrayList(set);
        return set.stream().collect(Collectors.toList());
    }

    public Map<Integer, People> set2Map(Set<People> set) {
        return set.stream().collect(Collectors.toMap(People::getAge, x -> x));
    }

    public List<People> map2List(Map<Integer, People> map) {
//        return Lists.newArrayList(map.values());
        /**
         * 注意这里 需要用entrySet来进行stream化，stream化的对象是{@link Map.Entry}
         */
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public Set<People> map2Set(Map<Integer, People> map) {
//        return Sets.newHashSet(map.values());
        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
    }

    //age一样的放入同一个对象
    public Map<Integer, List<People>> list2MapList(List<People> list) {
        //每个元素都会构造 List 效率不好
        //这里必须传入 第三 merge函数，否则 一样的key 会丢元素
        /**
         * {@link List#addAll(Collection)}返回值是 boolean 所以 没法化简lamda写法
         */
        return list.stream().collect(Collectors.toMap(People::getAge, Lists::newArrayList, (x, y) -> {
            x.addAll(y);
            return x;
        }));
    }

    public Map<Integer, Set<People>> set2MapSet(Set<People> set) {
        return set.stream().collect(Collectors.toMap(People::getAge, Sets::newHashSet, (x, y) -> {
            x.addAll(y);
            return x;
        }));
    }

    public Map<Integer, Set<People>> set2MapList(List<People> list) {
        return list.stream().collect(Collectors.toMap(People::getAge, Sets::newHashSet, (x, y) -> {
            x.addAll(y);
            return x;
        }));
    }

    public List<List<People>> mapList2ListList(Map<Integer, List<People>> map) {
        return map.values().stream().flatMap(x -> Stream.of(x)).collect(Collectors.toList());
    }

    public Set<Set<People>> mapList2SetSet(Map<Integer, Set<People>> map) {
        return map.values().stream().flatMap(x -> Stream.of(x)).collect(Collectors.toSet());
    }

    //与上面的区别，仅是 streamer的获取
    public List<People> mapList2List(Map<Integer, List<People>> map) {
        return map.values().stream().flatMap(x -> x.stream()).collect(Collectors.toList());
    }

    /**
     * 有以上函数，基本就可以实现自由转换了
     */

    /**
     * --------------------------------------------------------------
     * demos
     *
     * array
     * List
     * Map
     * Set
     * --------------------------------------------------------------
     */

    public People[] list2Array(List<People> list) {
//        return list.toArray(new People[0]); 这个带个0，感觉怪，所以推荐下面的实现
        return list.stream().toArray(People[]::new);
    }

    public People[] set2Array(Set<People> set) {
//        return set.toArray(new People[0]);
        return set.stream().toArray(People[]::new);
    }

    public List<People> array2List(People[] array) {
        return Arrays.asList(array);
    }

    public Set<People> array2Set(People[] array) {
        return Sets.newHashSet(array);
    }
}
