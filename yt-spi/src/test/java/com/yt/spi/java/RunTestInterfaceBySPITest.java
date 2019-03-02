package com.yt.spi.java;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/2.
 */
@Test
public class RunTestInterfaceBySPITest {

    @Test
    public void test() {
        RunTestInterfaceBySPI runTestInterfaceBySPI = new RunTestInterfaceBySPI();
        runTestInterfaceBySPI.runTestInterfaceBySPI();
    }
}
