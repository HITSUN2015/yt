package com.yt.design.pattern.structure.decorator;

/**
 * Created by yantong on 2019/2/18.
 * 实现附加功能B
 */
public class ConcreteDecoratorB extends Decorator {

    @Override
    public void method() {
        super.method();
        pluginMethodB();
    }

    private void pluginMethodB() {
        System.out.println("ConcreteDecoratorB run pluginMethodB");
    }
}
