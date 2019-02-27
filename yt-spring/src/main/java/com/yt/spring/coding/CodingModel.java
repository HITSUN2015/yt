package com.yt.spring.coding;

/**
 * @author SUN
 * @create 2019-02-27 下午9:34
 * @desc 用于编程实现IOC的演示
 */
public class CodingModel {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CodingModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
