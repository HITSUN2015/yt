package com.yt.jdk.thread.aqs;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CyclicBarrierDemoTest {

    @Test
    public void demo() throws InterruptedException {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        demo.demo();
        TimeUnit.SECONDS.sleep(10);
    }
}
