package com.yt.design.pattern.decorator;

/**
 * Created by yantong on 2019/2/18.
 * 装饰类的公用代码抽象出来
 */
public abstract class Decorator implements Component {

    private Component component;//这里别想成是最基础的那个实现，想成是任意的一个实现

    /**
     * 这个set方法，也可以转换为 每个装饰子类的 构造方法，这样客户端代码 更简洁
     * @param component
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void method() {
        component.method();
    }
}
