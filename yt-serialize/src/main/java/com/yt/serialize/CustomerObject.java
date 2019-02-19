package com.yt.serialize;

import java.io.Serializable;

/**
 * Created by yantong on 2019/2/19.
 *
 * idea自动生成序列号：
 *      ->Settings
 *      ->搜索：Serialization class without 'serialVersionUID'
 *      ->打上勾
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
