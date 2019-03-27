package com.yt.jdk.thread.interrupt;/**
 * Created by SUN on 19/3/27.
 */

import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-27 下午8:32
 * @desc
 */
public class InterruptDemoTest {

    @Test
    public void timeUnitSleepTest() {
        InterruptDemo demo = new InterruptDemo();
        demo.timeUnitSleep();
    }

    @Test
    public void threadSleepTest() {
        InterruptDemo demo = new InterruptDemo();
        demo.threadSleep();
    }

    @Test
    public void futureSleepTest() {
        InterruptDemo demo = new InterruptDemo();
        demo.futureSleepOutterInterrupt();
    }


}
