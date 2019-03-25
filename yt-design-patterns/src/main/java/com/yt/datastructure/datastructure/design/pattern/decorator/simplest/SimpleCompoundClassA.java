package com.yt.datastructure.datastructure.design.pattern.decorator.simplest;

/**
 * Created by yantong on 2019/2/18.
 */
public class SimpleCompoundClassA implements SimpleInterface {

    private SimpleInterface baseClass;

    public SimpleCompoundClassA(SimpleInterface baseClass) {
        this.baseClass = baseClass;
    }

    @Override
    public void method() {
        baseClass.method();
        pluginMethodA();
    }

    private void pluginMethodA() {
        System.out.println("SimpleCompoundClassA pluginMethodA");
    }
}
