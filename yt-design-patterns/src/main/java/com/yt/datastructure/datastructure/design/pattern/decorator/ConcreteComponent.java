package com.yt.datastructure.datastructure.design.pattern.decorator;

/**
 * Created by yantong on 2019/2/18.
 * 业务基础实现类
 */
public class ConcreteComponent implements Component {

    @Override
    public void method() {
        System.out.println("ConcreteComponent run component");
    }
}
