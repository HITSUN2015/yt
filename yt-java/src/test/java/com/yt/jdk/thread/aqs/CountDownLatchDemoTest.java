package com.yt.jdk.thread.aqs;

import com.yt.jdk.thread.aqs.sync.CountDownLatchDemo;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/27.
 */
public class CountDownLatchDemoTest {

    @Test
    public void demo() {

        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.demo();

    }
}
