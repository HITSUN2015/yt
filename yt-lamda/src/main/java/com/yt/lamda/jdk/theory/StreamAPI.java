package com.yt.lamda.jdk.theory;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;

/**
 * Created by yantong on 2019/3/15.
 *
 * streams have three parts: a data source, zero or more intermediate operations, and zero or one terminal operation.
 * All intermediate operations are lazy
 * {@link Stream}
 * 分类：并行流 parallel() 会启动多线程
 */
public class StreamAPI {

    /**
     * 这里关于stream 有一个限制，不同于spark的rdd
     *
     * streamA —> 只能生成一个StreamB（一条链映射到底）
     * 任何进行终端输出的Stream，没法再继续进行Stream操作，（终端输出一次，不能再链下去）
     * 以上两种情况 会抛出：java.lang.IllegalStateException: stream has already been operated upon or closed
     */
    public void map(StreamConstructor<String> constructor) {
        Stream<String> stream = makeDemo(constructor);
        //filter 与这个类似
        Stream<String> mapStream = stream.map(x -> x + "laal");
        printStream(mapStream);

        //这里 stream 是个流的概念，只能执行一次 // TODO: 2019/3/15 哪里限制的
        //需要重新生成stream
        //这里 如果 不是的话，是必须提前filter一遍么？ // TODO: 2019/3/15
        //各种异常需要提前 处理 eg：长度不够

        IntStream mapIntStream = makeDemo(constructor).mapToInt(x -> Integer.parseInt(x.substring(0, 2)));
        printStream(mapIntStream);

        DoubleStream mapDoubleStream = makeDemo(constructor).mapToDouble(x -> Double.parseDouble(x.substring(0, 3)));
        printStream(mapDoubleStream);

        LongStream mapLongStream = makeDemo(constructor).mapToLong(x -> Long.parseLong(x.substring(0, 4)));
        printStream(mapLongStream);
    }

    /**
     * 规约操作（reduction operation）(说规约 要能反应出是reduce 这个翻译真是。。。)
     * 又被称作折叠操作（fold）
     * @param constructor
     */
    public void reduce(StreamConstructor<String> constructor) {
        //这里是按 string 排序的
        //BinaryOperator.minBy()
        Optional<String> reduceMinValue = makeDemo(constructor).reduce(BinaryOperator.minBy(Comparator.naturalOrder()));
        System.out.println(reduceMinValue.get());

        //BinaryOperator.maxBy()
        Optional<String> reduceMaxValue = makeDemo(constructor).reduce(BinaryOperator.maxBy(Comparator.naturalOrder()));
        System.out.println(reduceMaxValue.get());

        /**
         * {@link java.util.function.BiFunction} 是二元运算
         * 实际上 这个和spark的 aggregate 一样了
         * BiFunction.apply()
         */
        Optional<String> reduceBinaryValue = makeDemo(constructor).reduce((x, y) -> x + "插塞" + y);
        System.out.println(reduceBinaryValue.get());

        /**
         * 这种 多线程 分区聚合 返回的不是Optional对象
         * 这个接口是我用的最多的接口。。。可笑的是，当时不知道reduce有这个接口，面试的时候。。。说不了解。。。
         */
        String partitionReduceValue = makeDemo(constructor).reduce("(每个分区的初始值)", (x, y) -> "[分区内合并" + x + y + "分区内合并]",
                (x, y) -> "[分区外合并" + x + y + "分区外合并]");
        System.out.println(partitionReduceValue);

        /**
         * TODO 这个方法 可能不用多线程
         */
        String value = makeDemo(constructor).reduce("(每个分区的初始值)", (x, y) -> "[分区外合并" + x + y + "分区外合并]");
        System.out.println(value);



        /**
         * 应用类
         * 可以看出 reduce 也会遍历 结合，处理 每两个元素之间的关系
         *
         * 如果一个for循环 需要 循环体外的一个元素 用来记录最终的操作结果，并且其为最终需要的结果
         *
         * 这个 loop 可以替换为reduce
         *
         * eg:求最长的string的最值
         */
        List<String> list = new ArrayList<String>() {{
            add("add");
            add("abcd");
        }};
        //loop
        String maxLengthString = null;
        for (String s : list) {
            int beforeLength = maxLengthString == null ? 0 : maxLengthString.length();
            if (s.length() > beforeLength) {
                maxLengthString = s;
            }
        }

        //reduce
        String result = list.stream().reduce((x, y) -> x.length() >= y.length() ? x : y).get();

    }

    public void toArray(StreamConstructor<String> constructor) {
        Object[] objectValues = makeDemo(constructor).toArray();
        /**
         * {@link java.util.function.IntFunction#apply(int)}
         * 这个 函数 只是 输入一个数字 返回一个对象
         *
         * 这里是返回的 Array对象，仅用来初始化 数组
         * 正如 demo，应该是完全用来输出 准确数组类型的
         * 否则上面的写法 toArray需要传入 class参数
         */
        String[] stringValues = makeDemo(constructor).toArray(String[]::new);
        for (int i = 0; i < stringValues.length; i++) {
            System.out.println(stringValues[i]);
        }
        //如下写法会报：java.lang.IllegalStateException: Begin size 3 is not equal to fixed size 0
//        String[] stringValues = makeDemo(constructor).toArray((x) -> {
//            System.out.println(x);
//            return new String[0];
//        });
    }

    /**
     * {@link Comparator}
     * {@link java.util.Comparators}
     * @param constructor
     */
    public void sort(StreamConstructor<String> constructor) {
        //自然String升序
        Stream<String> sortedStream = makeDemo(constructor).sorted();
        printStream(sortedStream);

        /**
         * {@link Comparator} static method
         */
        /**
         * {@link java.util.Comparators.NaturalOrderComparator} 枚举型实现接口 并提供方法实现 是 Singleton？TODO
         */
        Stream<String> ascStream = makeDemo(constructor).sorted(Comparator.naturalOrder());
        printStream(ascStream);

        Stream<String> descSortedStream = makeDemo(constructor).sorted(Comparator.reverseOrder());
        printStream(descSortedStream);

        //控制 null 的顺序
        Stream<String> nullFirstAscStream = constructor.generateStream(null, "213", "fasdf").sorted(Comparator.nullsFirst(Comparator.naturalOrder()));
        printStream(nullFirstAscStream);
        Stream<String> nullLasAscStream = constructor.generateStream(null, "213", "fasdf").sorted(Comparator.nullsLast(Comparator.naturalOrder()));
        printStream(nullLasAscStream);

        // 这里的参数名称 keyExtractor key代表要比较的对象 所以一个参数是 比较对象抽取器
        Stream<String> comparingStream = makeDemo(constructor).sorted(Comparator.comparing(String::length));
        printStream(comparingStream);

        //这个方法比上个方法 二外需要传入一个比较器
        Stream<String> comparingAndComparatorStream = makeDemo(constructor).sorted(Comparator.comparing(String::length, Comparator.naturalOrder()));
        printStream(comparingAndComparatorStream);

        //只是 具化一下 Comparator.comparing，comparingLong，comparingDouble 略
        Stream<String> comparing2Int = makeDemo(constructor).sorted(Comparator.comparingInt(Integer::parseInt));
        printStream(comparing2Int);

        // TODO: 2019/3/16   Comparators
    }

    /**
     * 参数要求：输入任意，输出是Stream类型，
     * 可以把多个Stream或可以转换为Stream（各种集合）联合成一个Stream
     * @param constructor
     */
    public void flatMap(StreamConstructor<String> constructor) {
        //这个demo 有点特殊
        Stream<String> flatMapStream = makeDemo(constructor).flatMap(Stream::of);
        printStream(flatMapStream);

        List<List<String>> complexList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<String> insideStringList = Lists.newArrayList();
            insideStringList.add(i + "-1str");
            insideStringList.add(i + "-2str");
            complexList.add(insideStringList);
        }
        flatMapStream = complexList.stream().flatMap(List::stream);
        printStream(flatMapStream);
    }

    //[非并行模] forEach与forEachOrdered一致
    public void foreach(StreamConstructor<String> constructor) {
        //[并行下]，打印顺序会 改变
        makeDemo(constructor).parallel().forEach(System.out::println);

        //[并行下]，打印顺序一致
        makeDemo(constructor).forEachOrdered(System.out::println);
    }

    public void match(StreamConstructor<String> constructor) {
        //用来判断 全部符合？ 存在一个符合？ 均不符合（全部符合取反 ）？
        boolean allLengthBiggerThanFour = makeDemo(constructor).allMatch(x -> x.length() > 4);
        System.out.println(allLengthBiggerThanFour);

        boolean existsOneLengthBiggerThanFour = makeDemo(constructor).anyMatch(x -> x.length() > 4);
        System.out.println(existsOneLengthBiggerThanFour);

        boolean noOneLengthBiggerThanFour = makeDemo(constructor).noneMatch(x -> x.length() > 4);
        System.out.println(noOneLengthBiggerThanFour);
    }

    public void mix(StreamConstructor<String> constructor) {
        Optional<String> testSingleValue = null;
        Stream<String> testStreamValue = null;
        testSingleValue = makeDemo(constructor).max(Comparator.naturalOrder());
        System.out.println(testSingleValue);
        testSingleValue = makeDemo(constructor).min(Comparator.naturalOrder());
        System.out.println(testSingleValue);

        testStreamValue = constructor.generateStream("asfdf", "a", "a").distinct();
        printStream(testStreamValue);

        //这个是什么场景。。。anyMatch是判断，filter + findFirst取值？
        //如果是 最大值，直接用max了，实在没想到好的场景
        testSingleValue = makeDemo(constructor).findFirst();
        System.out.println(testSingleValue);
        //单线程下 应该是返回第一个，但是并没有保证，多线程下，返回任意一个
        testSingleValue = makeDemo(constructor).findAny();
        System.out.println(testSingleValue);

        long counter = makeDemo(constructor).count();
        System.out.println(counter);

        testStreamValue = makeDemo(constructor).limit(2);
        printStream(testStreamValue);
        testStreamValue = makeDemo(constructor).skip(2);
        printStream(testStreamValue);

        //推荐https://www.baeldung.com/java-streams-peek-api
        //注意事项：这个是一个intermediate操作，如果没有terminal操作，懒计算不会执行，与spark一样
        //用法1：debug
        //用法2：有些映射是 将 原对象完全 映射 为另一个对象：map
        //       有些映射是 将 原对象的一部分 映射为另一个值（原对象不变）:peek（不需要返回值）
        testStreamValue = makeDemo(constructor).peek(String::toLowerCase);
        printStream(testStreamValue);

        makeDemo(constructor).close();

        //测试是 有teminal operation 不能触发onClose方法，必须调用close方法
        makeDemo(constructor).onClose(() ->{
            System.out.println("finish run");
        }).close();

        boolean isParallel = makeDemo(constructor).isParallel();
        System.out.println(isParallel);

        makeDemo(constructor).iterator();

        //并行化
        makeDemo(constructor).parallel();
        //串行化
        makeDemo(constructor).sequential();
    }

    public void spliterator(StreamConstructor<String> constructor) {
        // TODO: 2019/3/16
        makeDemo(constructor).spliterator();
    }

    public void unordered(StreamConstructor<String> constructor) {
        //对串行流，几乎没有影响
        //并行 流 会影响 性能、输出，如果数据源
        makeDemo(constructor).unordered();
    }

    /**
     * 参数一：Collector<? super T, A, R> collector
     * {@link Collector} TODO
     * {@link Collectors} TODO
     * 参数二：Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner
     *
     * 参见：https://www.cnblogs.com/CarpenterLee/p/6550212.html
     * @param constructor
     */
    public void collect(StreamConstructor<String> constructor) {
        //Collector<? super T, A, R> collector
        //工具类
//        makeDemo(constructor).collect(Collectors.);
//
//        makeDemo(constructor).collect();

    }

    private static Stream<String> makeDemo(StreamConstructor<String> streamConstructor) {
        return streamConstructor.generateStream("3214", "21321", "4324");
    }

    private static void printStream(BaseStream stream) {
        Objects.requireNonNull(stream);
        Iterator it = stream.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
