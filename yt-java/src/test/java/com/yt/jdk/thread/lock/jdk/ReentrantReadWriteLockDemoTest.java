package com.yt.jdk.thread.lock.jdk;

import com.yt.demo.helper.util.TimeSleepHelper;
import org.testng.annotations.Test;


/**
 * Created by yantong on 2019/3/28.
 */
public class ReentrantReadWriteLockDemoTest {

    @Test
    public void testDemo() {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        demo.demo();
        TimeSleepHelper.sleepSeconds(20);
    }
}
