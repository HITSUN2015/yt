package com.yt.coding.pattern.create.builder;

import java.util.Properties;

public class TestPropertyBuilder implements AbstractTestPropertyBuilder {

    public static final String TEST_1 = "test1";
    public static final String TEST_2 = "test2";
    public static final String TEST_3 = "test3";
    public static final String TEST_4 = "test4";
    public static final String TEST_5 = "test5";

    private Properties properties = new Properties();

    @Override
    public Properties createProperty() {
        return properties;
    }

    @Override
    public void setTest5(String value3) {
        properties.setProperty(TEST_5, value3);
    }

    @Override
    public void setTest4(String value3) {
        properties.setProperty(TEST_4, value3);
    }

    @Override
    public void setTest3(String value3) {
        properties.setProperty(TEST_3, value3);
    }

    @Override
    public void setTest2(String value2) {
        properties.setProperty(TEST_2, value2);
    }

    @Override
    public void setTest1(String value1) {
        properties.setProperty(TEST_1, value1);
    }
}