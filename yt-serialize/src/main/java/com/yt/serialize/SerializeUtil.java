package com.yt.serialize;

/**
 * Created by yantong on 2019/2/19.
 */
public interface SerializeUtil {

    String serialize(Object object);

    <T>Object deserialize(String source, Class<T> clazz);
}
