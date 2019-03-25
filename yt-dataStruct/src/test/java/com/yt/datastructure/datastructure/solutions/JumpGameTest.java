package com.yt.datastructure.datastructure.solutions;

import com.yt.datastructure.datastructure.arithmetic.dynamicProgramming.DynamicProgramming;
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

    @Test
    public void testAnotherDPSolution() {
        JumpGame.anotherDPSolution();
    }
}
