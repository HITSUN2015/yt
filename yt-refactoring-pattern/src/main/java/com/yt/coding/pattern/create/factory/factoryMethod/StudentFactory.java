package com.yt.coding.pattern.create.factory.factoryMethod;

import com.yt.coding.pattern.create.instance.Student;
import com.yt.coding.pattern.create.instance.Person;

/**
 * Created by yantong on 2019/3/22.
 */
public class StudentFactory extends AbstractFactory {
    @Override
    public Person create() {
        return new Student();
    }

}
