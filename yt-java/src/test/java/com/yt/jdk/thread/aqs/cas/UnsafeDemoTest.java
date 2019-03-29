package com.yt.jdk.thread.aqs.cas;/**
 * Created by SUN on 19/3/28.
 */

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-03-28 下午8:52
 * @desc
 */
public class UnsafeDemoTest {

    @Test
    public void testGetUnsafeInstance() {
        String fieldName = "value";
        long offset = UnsafeDemo.getFieldOffset(UnsafeDemo.class, fieldName);
    }

    @Test(dependsOnMethods = "testGetUnsafeInstance")
    public void testCompareAndSet() {
        String fieldName = "value";
        UnsafeDemo demo = new UnsafeDemo();
        Assert.assertEquals(demo.value, 0);
        UnsafeDemo.compareAndSet(demo, fieldName, 0, 2);
        Assert.assertEquals(demo.value, 2);
        UnsafeDemo.compareAndSet(demo, fieldName, 0, 3);
        Assert.assertEquals(demo.value, 2);
    }

    @Test(dependsOnMethods = "testGetUnsafeInstance")
    public void testObjectSetProperty() {
        String fieldName = "value";
        UnsafeDemo demo = new UnsafeDemo();
        Assert.assertEquals(demo.value, 0);
        UnsafeDemo.objectSetProperty(demo, fieldName, 2);
        Assert.assertEquals(demo.value, 2);
        UnsafeDemo.objectSetProperty(demo, fieldName, 3);
        Assert.assertEquals(demo.value, 3);
    }

    @Test(dependsOnMethods = "testGetUnsafeInstance")
    public void testControlThread() {
        UnsafeDemo.controlThread();
    }
}
