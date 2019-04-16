package com.yt.coding.pattern.create.instance;

/**
 * Created by yantong on 2019/3/22.
 */
public class Student implements Person {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
