package com.yt.jdk.thread.aqs;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/27.
 */
public class SemaphoreDemoTest {

    @Test
    public void demo() {
        SemaphoreDemo demo = new SemaphoreDemo();
        demo.demo();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
