package com.yt.coding.pattern.structure.decorator;


import com.yt.coding.pattern.structure.decorator.simpler.BaseClass;
import com.yt.coding.pattern.structure.decorator.simpler.CompoundClassA;
import com.yt.coding.pattern.structure.decorator.simpler.CompoundClassB;
import com.yt.coding.pattern.structure.decorator.simpler.Interface;
import com.yt.coding.pattern.structure.decorator.simplest.SimpleBaseClass;
import com.yt.coding.pattern.structure.decorator.simplest.SimpleCompoundClassA;
import com.yt.coding.pattern.structure.decorator.simplest.SimpleInterface;
import com.yt.coding.pattern.structure.decorator.ugly.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yantong on 2019/2/18.
 */
@Test
public class DecoratorTest {

    /**
     * print:
     * ConcreteComponent run component
     * ConcreteDecoratorA run pluginMethodA
     * ConcreteDecoratorB run pluginMethodB
     */
    public void demo() {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        /**
         * 执行顺序 取决于 Decorator 子类实现method方法时，先调super 还是 增加的方法
         *
         * 如果先调用 增加的方法，则最后执行 基础method的代码
         *
         * 与每个Decorator的method中的顺序相关
         */
        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorB.setComponent(concreteDecoratorA);

        concreteDecoratorB.method();
    }

    @Test
    public void testUgly() {
        BaseInterface baseInterface = new BaseImpl();
        List<BaseInterface> list = new ArrayList<>();

        list.add(new ExtendA());
        list.add(new ExtendB());

        ExtendBaseImpl extendBase = new ExtendBaseImpl();
        extendBase.setBaseInterface(baseInterface);
        extendBase.setExtendList(list);

        extendBase.extendibleMethod();
    }

    @Test
    public void testSimple() {
        SimpleInterface base = new SimpleBaseClass();
        SimpleInterface compound = new SimpleCompoundClassA(base);

        compound.method();
    }

    @Test
    public void testSimpler() {
        Interface base = new BaseClass();
        Interface compoundA = new CompoundClassA(base);
        Interface compoundB = new CompoundClassB(compoundA);

        compoundB.method();
    }
}
