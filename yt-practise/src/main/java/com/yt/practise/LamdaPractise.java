package com.yt.practise;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
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


    }
}
