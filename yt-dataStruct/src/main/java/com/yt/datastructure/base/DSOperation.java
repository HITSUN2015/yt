package com.yt.datastructure.base;/**
 * Created by SUN on 19/3/26.
 */

/**
 * @author SUN
 * @create 2019-03-26 下午9:48
 * @desc // TODO: 19/3/26 这里写泛型 子类没写成只实现Integer
 */
public interface DSOperation {

    void add(Integer t);

    void delete(Integer t);

    Integer query(Integer v);
}
