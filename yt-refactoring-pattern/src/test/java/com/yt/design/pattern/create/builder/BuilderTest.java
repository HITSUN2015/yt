package com.yt.design.pattern.create.builder;

import com.yt.design.pattern.create.instance.Person;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/22.
 */
public class BuilderTest {

    @Test
    public void build() {
        PersonDirector pd = new PersonDirector();
        Person person = pd.constructPerson(new StudentFactory());
        System.out.println(person.toString());
    }
}
