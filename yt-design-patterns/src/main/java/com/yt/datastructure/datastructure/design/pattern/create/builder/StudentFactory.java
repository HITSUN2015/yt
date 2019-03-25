package com.yt.datastructure.datastructure.design.pattern.create.builder;

import com.yt.datastructure.datastructure.design.pattern.create.instance.Person;
import com.yt.datastructure.datastructure.design.pattern.create.instance.Student;

/**
 * Created by yantong on 2019/3/22.
 */
public class StudentFactory implements AbstractFactory {

    Person person;

    public StudentFactory() {
        person = new Student();
    }

    @Override
    public void buildName() {
        person.setName("Student name");
    }

    @Override
    public Person buildPerson() {
        return person;
    }

}
