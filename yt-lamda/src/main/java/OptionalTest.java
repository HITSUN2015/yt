/**
 * Created by SUN on 19/1/23.
 */

import java.util.Optional;

/**
 * @author SUN
 * @create 2019-01-23 下午11:44
 * @desc 测试Optional使用
 *
 * TODO 实现原理
 */
public class OptionalTest {

    public static void main(String[] args) {
        A a = null;
        String s = Optional.ofNullable(a)
                .map(x -> a.getB())
                .map(x -> x.getC())
                .map(x -> x.getName())
                .orElse("");
        Optional.ofNullable(s).ifPresent(System.out::print);
    }

    private class A {
        public A(B b) {
            this.b = b;
        }

        private B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    private class B {
        private C c;

        public C getC() {
            return c;
        }

        public void setC(C c) {
            this.c = c;
        }
    }

    private class C {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
