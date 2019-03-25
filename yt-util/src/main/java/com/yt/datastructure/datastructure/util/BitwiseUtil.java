package com.yt.datastructure.datastructure.util;

import java.util.BitSet;

/**
 * Created by yantong on 2019/3/5.
 *
 * {@link BitSet}
 */
public class BitwiseUtil {

    //bit 是 2 的指数 TODO 这个接口蛋疼
    //这个 接口 我还真没想好怎么提供比较好。。。值是0的时候 不能知道是哪一位
    public static int setBit(Integer source, Integer bit, Integer value) {
        if (null == source && (null == bit || null == value)) {
            throw new IllegalArgumentException();
        }
        if (null != value && value != 1 && value != 0) {
            throw new IllegalArgumentException();
        }
        if (null == source) {
            return bit * value;
        }
        BitSet bitSet = new BitSet(source);
        bitSet.set(1, 1);
        if (null == bit || value == null || value == 0) {
            return source;
        }
        return source | bit;
    }
}
