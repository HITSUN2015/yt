package com.yt.coding.pattern.action.strategy;/**
 * Created by SUN on 19/3/23.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-23 下午9:41
 * @desc
 */
public class StrategyTest {

    @Test
    public void test() {
        Context context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
