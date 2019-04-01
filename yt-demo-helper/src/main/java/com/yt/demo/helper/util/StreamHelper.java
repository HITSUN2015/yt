package com.yt.demo.helper.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

/**
 * Created by yantong on 2019/4/1.
 */
public class StreamHelper {

    public static Stream<String> makeDemo(StreamConstructor<String> streamConstructor) {
        return streamConstructor.generateStream("3214", "21321", "4324");
    }

    public static void printStream(BaseStream stream) {
        Objects.requireNonNull(stream);
        Iterator it = stream.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
