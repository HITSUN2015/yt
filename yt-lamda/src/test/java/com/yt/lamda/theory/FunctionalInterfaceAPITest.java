package com.yt.lamda.theory;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/15.
 */
@Test
public class FunctionalInterfaceAPITest {

    @Test
    public void testFunctionInterface() {
        FunctionalInterfaceAPI functionalInterfaceAPI = new FunctionalInterfaceAPI();
        functionalInterfaceAPI.testFunctionCompose();
        functionalInterfaceAPI.testFunctionAndThen();
        functionalInterfaceAPI.testIdentity();
    }


}
