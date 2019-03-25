package com.yt.datastructure.datastructure.serialize;

import java.io.Serializable;

/**
 * Created by yantong on 2019/2/19.
 *
 * idea自动生成序列号：
 *      ->Settings
 *      ->搜索：Serialization class without 'serialVersionUID'
 *      ->打上勾
 *
 * 　　显式地定义serialVersionUID有两种用途：
 　　　　1、 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
 　　　　2、 在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
 */
public class CustomerObject implements Serializable {

    private static final long serialVersionUID = -8348979313561759106L;

    private String field;

    public CustomerObject() {
    }

    public CustomerObject(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "CustomerObject{" +
                "field='" + field + '\'' +
                '}';
    }
}
