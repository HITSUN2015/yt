package com.yt.lamda.jdk.theory;

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

    @Test
    public void testToArray() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.toArray(x -> Stream.of(x));
    }

    @Test
    public void testSort() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.sort(x -> Stream.of(x));
    }

    @Test
    public void testForeach() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.foreach(x -> Stream.of(x));
    }

    @Test
    public void testMatch() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.match(x -> Stream.of(x));
    }

    @Test
    public void testFlatMap() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.flatMap(x -> Stream.of(x));
    }

    @Test
    public void testMix() {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.mix(x -> Stream.of(x));
    }
}
