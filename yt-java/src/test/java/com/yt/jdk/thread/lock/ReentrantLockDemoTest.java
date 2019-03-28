package com.yt.jdk.thread.lock;

import com.yt.jdk.thread.aqs.lock.ReentrantReadWriteLockDemo;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/28.
 */
public class ReentrantLockDemoTest {

    @Test
    public void testDemo() throws InterruptedException {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        demo.demo();
        TimeUnit.SECONDS.sleep(10);
    }
}
