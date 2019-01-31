package com.yt.lamda;

import com.yt.lamda.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yantong on 2019/1/29.
 */
public class Sort {

    private static Logger logger = LoggerFactory.getLogger(Sort.class);

    public static void main(String[] args) {
        testStringSort();
    }

    private void testNormalSort() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(2, 30, "张三"));
        teachers.add(new Teacher(2, 19, "张si"));
        teachers.add(new Teacher(1, 45, "zhangwu"));

        logger.error("test order by id");
        teachers.sort(Comparator.comparing(Teacher::getId));
        teachers.forEach(x -> logger.error(x.toString()));
        logger.error("test order by age");
        teachers.sort(Comparator.comparing(Teacher::getAge));
        teachers.forEach(x -> logger.error(x.toString()));
        logger.error("test order by id then by age");
        teachers.sort(Comparator.comparing(Teacher::getId).thenComparing(Teacher::getAge));
        teachers.forEach(x -> logger.error(x.toString()));
        logger.error("test order by id desc");
        teachers.sort(Comparator.comparing(Teacher::getId));
        Collections.reverse(teachers);//或参考下面的
        teachers.forEach(x -> logger.error(x.toString()));
        logger.error("test order by id asc and then by age desc");
        teachers.get(0).setAge(18);
        teachers.sort(Comparator.comparing(Teacher::getId).thenComparing(x -> -x.getAge()));
        teachers.forEach(x -> logger.error(x.toString()));
    }

    private static void testStringSort() {
        String sortString = "2,3,1";
        Teacher.setSortString(sortString);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(3, 30, "张三"));
        teachers.add(new Teacher(2, 19, "张si"));
        teachers.add(new Teacher(1, 45, "zhangwu"));
        teachers.add(new Teacher(5, 43, "zhangw3213u"));
        teachers.sort(Comparator.comparing(Teacher::getSortIndex));
        teachers.forEach(x -> logger.error(x.toString()));
    }
    
    
}