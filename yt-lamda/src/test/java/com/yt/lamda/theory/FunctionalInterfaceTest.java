package com.yt.lamda.theory;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/15.
 */
@Test
public class FunctionalInterfaceTest {

    @Test
    public void testFunctionInterface() {
        FunctionalInterface functionalInterface = new FunctionalInterface();
        functionalInterface.testFunctionCompose();
        functionalInterface.testFunctionAndThen();
        functionalInterface.testIdentity();
    }


}
