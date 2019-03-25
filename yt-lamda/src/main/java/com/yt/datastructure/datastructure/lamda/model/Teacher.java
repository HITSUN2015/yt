package com.yt.datastructure.datastructure.lamda.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yantong on 2019/1/29.
 */
public class Teacher {

    private static Map<Integer, Integer> sortMap = new HashMap<>();

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

    public static void setSortString(String sortString) {
        sortMap = new HashMap<>();
        if (null != sortString && sortString.trim().length() != 0) {
            String[] values = sortString.split(",");
            for(int i = 0; i < values.length ; i++) {
                sortMap.put(Integer.parseInt(values[i]), i);
            }
        }
    }

    public int getSortIndex() {
        Integer index = sortMap.get(id);
        if (null == index) {
            return Integer.MAX_VALUE;
        } else {
            return index;
        }
    }
}
