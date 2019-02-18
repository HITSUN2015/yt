package com.yt.design.pattern.decorator.simpler;

/**
 * Created by yantong on 2019/2/18.
 */
public class CompoundClassB implements Interface{

    private Interface interfaceImpl;//这里别想成是最基础的那个实现，想成是任意的一个实现

    public CompoundClassB(Interface interfaceImpl) {
        this.interfaceImpl = interfaceImpl;
    }

    @Override
    public void method() {
        interfaceImpl.method();
        methodB();
    }

    private void methodB() {
        System.out.println("CompoundClassB methodB");
    }
}
