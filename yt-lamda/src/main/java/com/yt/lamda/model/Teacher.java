package com.yt.lamda.model;

/**
 * Created by yantong on 2019/1/29.
 */
public class Teacher {
    Integer id;
    Integer age = 0;
    String name;

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
