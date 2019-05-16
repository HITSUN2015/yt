package com.yt.coding.pattern.create.builder;

import java.util.Properties;

/**
 * @author SUN
 * @create 2019-05-12 23:12
 * @desc
 */
public interface AbstractTestPropertyBuilder {
    Properties createProperty();

    void setTest5(String value3);

    void setTest4(String value3);

    void setTest3(String value3);

    void setTest2(String value2);

    void setTest1(String value1);
}
