package com.yt.arithmetic.solutions;

import com.yt.arithmetic.arithmetic.dynamicProgramming.DynamicProgramming;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/27.
 */
@Test
public class WordBreakTest {

    @Test
    public void testDyanamic() {
        DynamicProgramming dp = new WordBreak();
        dp.danamicProgrammingSolution();
    }
}
