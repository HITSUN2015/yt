package com.yt.jvm.gc;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/11.
 */
@Test
public class GCUtilTest {

    @Test
    public void test() {
        GCUtil.getGCCollector();
    }
}
