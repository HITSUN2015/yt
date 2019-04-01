package com.yt.lamda.jdk;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by yantong on 2019/1/29.
 *
 * {@link Optional}
 *
 * 返回值非Optional的方法有
 *      {@link Optional#get()}:T
 *      直接获取value，没有会抛出异常
 *
 *      {@link Optional#isPresent()}:boolean
 *      这个方法返回值是boolean 不会再出现空指针异常了
 *
 *      {@link Optional#orElse(Object)}:T
 *      {@link Optional#orElseGet(Supplier)}:T
 *      {@link Optional#orElseThrow(Supplier)}:T
 *      这三个方法，实际是给空指针异常时，提供返回值的
 *      在orElseThrow的Exception是{@link NullPointerException}时，这个方法等于{@link Optional#get()}
 *
 * 所以总结：
 *      除非null情况就是要抛出{@link NullPointerException}
 *      否则都要提供orElse方法
 *
 * 如果遇到属性是Optional可能会用到flatMap，不过一般都不这么写属性，optional是为了解决问题的，而非制造问题再解决问题
 */
public class OptionalDemo {

    /**
     * 优化：getParent().getChild() 过程抛出空指针
     *       if(null == x) ...;
     *       else ...;
     */
    public void nullBranch() {
        Parent parent = new Parent();

        //注意不要写成这样。。。Optional是允许结果是null，过程中是null它也不会管理
//        int age0 = Optional.ofNullable(parent).map(x -> x.getChild().getAge()).orElse(-1);

        int age = Optional.ofNullable(parent).map(Parent::getChild).map(Child::getAge).orElse(-1);
    }

    /**
     * 优化：null == x ? y : z
     * 这个本身就属于上面的case
     *
     * 略
     */

    private class Parent{
        private Child child;

        public Child getChild() {
            return child;
        }

        public void setChild(Child child) {
            this.child = child;
        }
    }

    private class Child{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
