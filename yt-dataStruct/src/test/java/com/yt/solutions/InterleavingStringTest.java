package com.yt.solutions;

import com.yt.arithmetic.dynamicProgramming.DynamicProgramming;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/26.
 */
@Test
public class InterleavingStringTest {

    @Test
    public void testPDSolution() {
        DynamicProgramming dp = new InterleavingString();
        dp.danamicProgrammingSolution();
    }
}