package com.yt.coding.pattern.create.builder;

import org.testng.annotations.Test;

import java.util.Properties;

/**
 * Created by yantong on 2019/3/22.
 */
public class BuilderTest {

    private String test3423 = getTestfds();

    private String getTestfds() {
        String testfds = "testfds";
        return testfds;
    }


    @Test
    public void build() {
        final AbstractTestPropertyBuilder testPropertyBuilder = new TestPropertyBuilder();
        testPropertyBuilder.setTest1("value1");
        testPropertyBuilder.setTest2("value2");
        testPropertyBuilder.setTest3("value3");
        testPropertyBuilder.setTest4("value4");
        testPropertyBuilder.setTest5("value5");
        Properties property = testPropertyBuilder.createProperty();
    }

}
