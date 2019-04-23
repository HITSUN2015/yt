package com.yt.coding.idea.keymap.demo.frequently;

/**
 * @author SUN
 * @create 2019-04-22 上午11:06
 * @desc {@link com.yt.coding.idea.keymap.ConvertToInstanceMethod}
 */
public class ConvertToInstanceMethodDemo {


    public static void method(ClassA classA, String p2, ClassB classB) {
        System.out.println(classA.getClass());
        System.out.println(classB.getClass());
        System.out.println(ClassB.class);
    }

    private void test() {
        method(new ClassA(), null, new ClassB());
    }

    private class ClassA{

    }

    private class ClassB {

    }
}
