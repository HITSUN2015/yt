package com.yt.practise;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by yantong on 2019/4/1.
 */
public class LamdaPractise {

    public static void main(String[] args) {
        /**
         print:
         java.util.function.Function$$Lambda$3/787604730@306a30c7
         java.util.function.Function$$Lambda$3/787604730@306a30c7
         java.util.function.Function$$Lambda$3/787604730@306a30c7
         */
        IntStream.of(3, 4, 5).map( x -> x * 2).mapToObj(Integer::valueOf).forEach( x -> System.out.println(Function.identity()));

        IntStream.of(3, 4, 5).map( x -> x * 2).mapToObj(Integer::valueOf).collect(Collectors.toMap(Function.identity(), x -> x.toString() + 2)).forEach((x, y) -> System.out.println(x + " -> " + y));

        double result = DoubleStream.of(1, 34, 5).reduce((x, y) -> Math.min(x, y)).getAsDouble();
        System.out.println(result);

        result = DoubleStream.of(1, 34, 5).reduce(Double.MAX_VALUE, (x, y) -> Math.min(x, y));
        System.out.println(result);

        String str = Stream.of("str1", "str2", "str3", "str4").parallel().reduce("fsdff", (x, y) -> x.length() < y.length() ? x : y, (x, y) -> x.length() < y.length() ? x : y);
        System.out.println(str);
    }
}
