package com.yt.design.pattern.create.factory.simple;

import com.yt.design.pattern.create.instance.Person;
import com.yt.design.pattern.create.instance.Student;
import com.yt.design.pattern.create.instance.Teacher;

import java.util.Calendar;

/**
 * Created by yantong on 2019/3/22.
 *
 * 个人感觉就是利用多态
 */
public class SimpleFactory {

    public static Person create(int type) {
        if(type == 1){
            return new Student();
        } else if (type == 2) {
            return new Teacher();
        }
        // TODO: 2019/3/22 这里 是不是得抛异常
        throw new IllegalArgumentException();
    }

    /**
     *  其他 方法名：valueOf()
     *  常用来 进行 对象转换
     *  {@link Integer#valueOf(int)}
     *
     *  其他方法名：getInstance()
     *  {@link Calendar#getInstance()}
     */
}
