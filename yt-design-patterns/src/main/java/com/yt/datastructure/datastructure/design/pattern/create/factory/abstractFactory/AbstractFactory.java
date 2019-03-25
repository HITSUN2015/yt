package com.yt.datastructure.datastructure.design.pattern.create.factory.abstractFactory;

import com.yt.datastructure.datastructure.design.pattern.create.instance.Langurage;
import com.yt.datastructure.datastructure.design.pattern.create.instance.Person;

/**
 * Created by yantong on 2019/3/22.
 * 根据代码， 个人理解是：
 * 可能是一个功能，需要一组配件，A厂来做，需要提供这些实现，B厂来做 需要提供同样规格的实现
 *
 * 把 构造方法数退化为1 就是 {@link com.yt.datastructure.datastructure.design.pattern.create.factory.factoryMethod.AbstractFactory}
 */
public abstract class AbstractFactory {

    public abstract Person getPerson() ;

    public abstract Langurage getLangurage();
}
