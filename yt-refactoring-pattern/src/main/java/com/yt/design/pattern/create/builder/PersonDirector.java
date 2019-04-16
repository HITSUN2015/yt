package com.yt.design.pattern.create.builder;

import com.yt.design.pattern.create.instance.Person;

/**
 * Created by yantong on 2019/3/22.
 */
public class PersonDirector {

    public Person constructPerson(AbstractFactory pb) {

        pb.buildName();

        return pb.buildPerson();
    }

}
