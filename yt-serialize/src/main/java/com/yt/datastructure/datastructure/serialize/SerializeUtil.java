package com.yt.datastructure.datastructure.serialize;

/**
 * Created by yantong on 2019/2/19.
 */
public interface SerializeUtil {

    String serialize(Object object);

    <T>T deserialize(String source, Class<T> clazz);
}
