package com.yt.datastructure.datastructure.lamda;

import com.yt.datastructure.datastructure.lamda.model.Teacher;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yantong on 2019/1/29.
 * 个人更干净 optional适合用于 非集合的对象 才比较优雅
 * TODO
 */
public class LearnOptional {

    public static void main(String[] args) {
        testString();

//        testList();
    }

    private static void testString() {
        String testSource = "453w5";
        System.out.println(Optional.ofNullable(testSource).orElse(","));
    }

    private static void testList() {
        //获取 老师 姓名 的list
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher(1, "张三"));
        teacherList.add(new Teacher(2, null));

        List<String> nameList = teacherList.stream()
                .filter(teacher -> null != teacher.getName())
                .map(Teacher::getName)
                .collect(Collectors.toList());
        System.out.println(nameList.size());

    }

    private void testMap() {
        //获取 根据key 获取 某个tearcher的姓名


        Map<String, Teacher> id2TeacherMap = null;
//
//
//        Optional.ofNullable(id2TeacherMap).map((id) -> id.)
    }



}
