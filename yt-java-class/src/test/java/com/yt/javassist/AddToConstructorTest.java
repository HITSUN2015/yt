package com.yt.javassist;

import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/1.
 */
@Test
public class AddToConstructorTest {

    @Test
    public void test() {
        System.out.println("javassist add success");
        AddToConstructor addToConstructor = new AddToConstructor();
        addToConstructor.inserString("java.util.Date", "System.out.println(\"javassist add success\");");
    }
}
