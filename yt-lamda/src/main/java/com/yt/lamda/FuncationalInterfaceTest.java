package com.yt.lamda;

/**
 * Created by yantong on 2019/1/7.
 *
 * 函数式接口 要求只有一个抽象方法，且不能额外增加复写Object类的方法，才能被用于lamda表达式的创建式使用
 * 见：Learning.testInterfaceForLamda
 */
@FunctionalInterface
public interface FuncationalInterfaceTest {

    int test1();
}
