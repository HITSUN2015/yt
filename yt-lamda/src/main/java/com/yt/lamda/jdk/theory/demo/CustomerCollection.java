package com.yt.lamda.jdk.theory.demo;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by yantong on 2019/4/1.
 */
public class CustomerCollection<T> {

    private T[] datas = null;

    //这里我第一次实现时，是泛型，结果Base<>
    public Stream<T> stream() {
        return StreamSupport.stream(getSpliterator(), false);
    }

    /**
     * Characteristics:特征
     * TODO
     * @return
     */
    private Spliterator<T> getSpliterator() {
        // TODO: 2019/4/1 这里会抛异常
        return Spliterators.spliterator(datas, 0);
    }

    public T[] getDatas() {
        return datas;
    }

    public void setDatas(T[] datas) {
        this.datas = datas;
    }
}
