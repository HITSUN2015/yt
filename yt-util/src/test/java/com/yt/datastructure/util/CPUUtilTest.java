package com.yt.datastructure.util;

import com.yt.util.CPUUtil;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/8.
 */
@Test
public class CPUUtilTest {

    @Test
    public void test() {
        System.out.println(CPUUtil.getAvailableProcessors());
    }
}
