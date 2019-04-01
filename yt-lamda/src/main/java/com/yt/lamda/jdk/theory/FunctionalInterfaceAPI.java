package com.yt.lamda.jdk.theory;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yantong on 2019/3/15.
 * 以下为个人理解，具体接口不用在意里面的方法名称，观察输入与返回值即可
 *
 * {@link java.util.function.Function}
 * R apply(T t); 表达映射关系：由x -> y
 *
 * {@link java.util.function.Consumer}
 * void accept(T t); 表达运行，无需返回结果
 *
 * {@link java.util.function.Predicate}
 * boolean test(T t); 表达判断，给输入，返回true or false
 *
 * {@link java.util.function.Supplier}
 * T get(); 表达获取值，没有输入，直接获取数据
 *
 * 本类列举一些，函数接口 提供的默认方法，自己造函数接口时，可以利用
 */
public class FunctionalInterfaceAPI {

    /**
     * {@link java.util.function.Function}
     * compose这个方法的参数是before，
     * 是把参数拼到这个funtion之前
     * 所以需要注意调用顺序
     */
    public void testFunctionCompose() {
        Function<Character, Integer> f1 = (x) -> x * 2;
        Function<Integer, String> f2 =(x) -> x + "String";
        Function f3 = f2.compose(f1);
        System.out.println(f3.apply('c'));
    }

    /**
     * {@link java.util.function.Function}
     * {@link java.util.function.Consumer}
     * 与 compose 相反 他是把 参数拼到后面
     */
    public void testFunctionAndThen() {
        Function<Character, Integer> f1 = (x) -> x * 2;
        Function<Integer, String> f2 =(x) -> x + "String";
        Function f3 = f1.andThen(f2);
        System.out.println(f3.apply('c'));
    }

    /**
     * 在lamda中强行使用 {@link Function#andThen(Function)} 或 {@link Function#compose(Function)}
     */
    public void badUse() {
        /**
         * 这里 () -> {} 相当于构造一个 {@link FunctionalInterface} 的实例，但是不确定是其子接口 {@link Function}
         * 所以需要强行转换，才能应用default方法
         *
         * 但是通常，能够用default方法来连接两个{@link FunctionalInterface}实例，
         *      他的调用方法eg:{@link IntStream#map(IntUnaryOperator)}本身支持连续调用
         */
        IntStream.of(5, 20).mapToObj(Integer::valueOf).map(((Function<Integer, Integer>)(x ->  x * 2)).andThen(x -> (x + 2)));
    }

    /**
     * {@link java.util.function.Function}
     * 看着像，替换 x->x 这种写法
     */
    public void testIdentity() {
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
        }};
        // TODO: 2019/4/1 map 实现key调用Function.identity时，做了特殊处理，变成了值，而非对象
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), x -> x + 2));
        map.forEach((x, y) -> System.out.println(x + " -> " + y));
    }

    /**
     * {@link java.util.function.Predicate}
     * 与 或 非 equal
     * 略
     */

}
