package com.yt.design.pattern.decorator.simpler;

/**
 * Created by yantong on 2019/2/18.
 */
public class CompoundClassA implements Interface {

    private Interface baseClass;

    public CompoundClassA(Interface baseClass) {
        this.baseClass = baseClass;
    }

    @Override
    public void method() {
        baseClass.method();
        pluginMethodA();
    }

    private void pluginMethodA() {
        System.out.println("CompoundClassA pluginMethodA");
    }
}
