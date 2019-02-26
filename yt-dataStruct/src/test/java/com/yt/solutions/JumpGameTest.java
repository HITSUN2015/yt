package com.yt.solutions;

import com.yt.arithmetic.dynamicProgramming.DynamicProgramming;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/26.
 */
@Test
public class JumpGameTest {

    @Test
    public void testDynamicSolution() {
        DynamicProgramming jg = new JumpGame();
        jg.danamicProgrammingSolution();
    }
}
