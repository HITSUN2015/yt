package com.yt.lamda.theory;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.*;

/**
 * Created by yantong on 2019/3/15.
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
    }

    /**
     * 参数一：Collector<? super T, A, R> collector
     *
     * 参数二：Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner
     * @param constructor
     */
    public void collect(StreamConstructor<String> constructor) {
        //Collector<? super T, A, R> collector
        //工具类
        makeDemo(constructor).collect(Collectors.);

        makeDemo(constructor).collect();


    }

    public void toArray(StreamConstructor<String> constructor) {

    }

    public void sort(StreamConstructor<String> constructor) {

    }

    public void flatMap(StreamConstructor<String> constructor) {

    }

    public void foreach(StreamConstructor<String> constructor) {

    }

    public void match(StreamConstructor<String> constructor) {

    }

    public void mix(StreamConstructor<String> constructor) {
        makeDemo(constructor).max();
        makeDemo(constructor).distinct();
        makeDemo(constructor).findFirst();
        makeDemo(constructor).count();
        makeDemo(constructor).findAny();
        makeDemo(constructor).limit();
        makeDemo(constructor).min();
        makeDemo(constructor).peek();
        makeDemo(constructor).skip();

        makeDemo(constructor).close();
        makeDemo(constructor).isParallel();
        makeDemo(constructor).iterator();
        makeDemo(constructor).onClose();
        makeDemo(constructor).parallel();
        makeDemo(constructor).sequential();
        makeDemo(constructor).spliterator();
        makeDemo(constructor).unordered();
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
