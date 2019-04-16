package com.yt.coding.pattern.create.builder;

import com.yt.coding.pattern.create.instance.Student;
import com.yt.coding.pattern.create.instance.Person;

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
