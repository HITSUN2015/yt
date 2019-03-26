package com.yt.design.pattern.create.factory.factoryMethod;

import com.yt.design.pattern.create.instance.Person;
import com.yt.design.pattern.create.instance.Student;

/**
 * Created by yantong on 2019/3/22.
 */
public class StudentFactory extends AbstractFactory {
    @Override
    public Person create() {
        return new Student();
    }

}