package com.yt.util;

import org.springframework.util.Assert;

/**
 * Created by yantong on 2019/1/7.
 */
public class AssertUtil {

    void test() {
        Assert.notNull("test", "这里主要 记录下 可以抛出参数异常 IllegalArgumentException");
    }
}
