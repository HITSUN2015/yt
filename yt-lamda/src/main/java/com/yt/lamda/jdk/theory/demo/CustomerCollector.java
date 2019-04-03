package com.yt.lamda.jdk.theory.demo;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by yantong on 2019/4/1.
 *
 * https://happyer.github.io/2016/12/09/2016-12-09-java8%20collector/
 * https://www.concretepage.com/java/jdk-8/java-8-stream-collect-example
 * todo
 */
public class CustomerCollector implements Collector {

    @Override
    public Supplier supplier() {
        return null;
    }

    @Override
    public BiConsumer accumulator() {
        return null;
    }

    @Override
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }

    private CustomerCollector() {
    }

    public static CustomerCollector of() {
        return new CustomerCollector();
    }
}
