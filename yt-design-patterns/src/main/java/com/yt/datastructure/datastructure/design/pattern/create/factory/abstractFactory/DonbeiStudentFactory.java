package com.yt.datastructure.datastructure.design.pattern.create.factory.abstractFactory;

import com.yt.datastructure.datastructure.design.pattern.create.instance.DongbeiLangurage;
import com.yt.datastructure.datastructure.design.pattern.create.instance.Langurage;
import com.yt.datastructure.datastructure.design.pattern.create.instance.Person;
import com.yt.datastructure.datastructure.design.pattern.create.instance.Student;

/**
 * Created by yantong on 2019/3/22.
 */
public class DonbeiStudentFactory extends AbstractFactory {
    @Override
    public Person getPerson() {
        return new Student();
    }

    @Override
    public Langurage getLangurage() {
        return new DongbeiLangurage();
    }
}
