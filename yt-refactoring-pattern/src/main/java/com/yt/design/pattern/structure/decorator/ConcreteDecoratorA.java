package com.yt.design.pattern.structure.decorator;

/**
 * Created by yantong on 2019/2/18.
 * 实现 附加功能A
 */
public class ConcreteDecoratorA extends Decorator {

    @Override
    public void method() {
        super.method();
        pluginMethodA();
    }

    private void pluginMethodA() {
        System.out.println("ConcreteDecoratorA run pluginMethodA");
    }
}
