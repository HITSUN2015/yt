package com.yt.util;

/**
 * Created by yantong on 2019/3/5.
 */
public class BitwiseUtil {

    //这个 接口 我还真没想好怎么提供比较好。。。值是0的时候 不能知道是哪一位
    public int setBit(Integer source, Integer bit, Integer value) {
        if (null == source && (null == bit || null == value)) {
            throw new IllegalArgumentException();
        }
        if (null != value && value != 1 && value != 0) {
            throw new IllegalArgumentException();
        }
        if (null == source) {
            return bit * value;
        }
        if (null == bit || value == null || value == 0) {
            return source;
        }
        return source | bit;
    }
}
