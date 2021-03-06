package com.yt.demo.helper.util;

import java.util.stream.Stream;

/**
 * Created by yantong on 2019/3/15.
 */
@FunctionalInterface
public interface StreamConstructor<T> {

    Stream<T> generateStream(T ...t);
}
