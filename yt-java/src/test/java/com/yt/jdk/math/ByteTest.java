package com.yt.jdk.math;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/4/2.
 */
@Test
public class ByteTest {

    @Test
    public void testFindNearestPow2() {
        ByteOperation byteOperation = new ByteOperation();
        int result = byteOperation.findNearestPow2(Integer.MAX_VALUE);
        System.out.println(result);
    }
}
