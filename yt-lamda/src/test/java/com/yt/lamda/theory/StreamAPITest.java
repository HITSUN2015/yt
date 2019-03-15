package com.yt.lamda.theory;

import org.testng.annotations.Test;

import java.util.stream.Stream;

/**
 * Created by yantong on 2019/3/15.
 */
@Test
public class StreamAPITest {

    @Test
    public void testStreamMapAPI() {
        StreamAPI streamAPI = new StreamAPI();
        // TODO: 2019/3/15 这里把 StreamConstructor 参数变为数字 我自己没懂，试出来的
        streamAPI.map(x -> Stream.of(x));
    }

    @Test
    public void testStreamReduceAPI() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.reduce(x -> Stream.of(x));
    }
}
