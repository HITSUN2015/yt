package com.yt.jdk.thread.aqs;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 */
public class PhaserDemoTest {

    @Test
    public void demo() throws InterruptedException {
        PhaserDemo demo = new PhaserDemo();
        demo.demo();
        TimeUnit.SECONDS.sleep(15);
    }
}
