package com.yt.design.pattern.create.factory.abstractFactory;

import com.yt.design.pattern.create.instance.*;

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
