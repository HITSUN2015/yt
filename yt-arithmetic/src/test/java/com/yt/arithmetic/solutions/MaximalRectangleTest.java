package com.yt.datastructure.solutions;

import com.yt.datastructure.arithmetic.dynamicProgramming.DynamicProgramming;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/26.
 */
@Test
public class MaximalRectangleTest {

    @Test
    void testDPSolution() {
        DynamicProgramming leetCode = new MaximalRectangle();
        leetCode.danamicProgrammingSolution();
    }
}
