package com.yt.coding.pattern.create.factory.factoryMethod;

import com.yt.coding.pattern.create.instance.Person;

/**
 * Created by yantong on 2019/3/22.
 *
 * 个人感觉 就是 当instance种类过多的时候，并且某些类型的构造会用到同样的逻辑
 *
 * 可以用这个 对 对象大类，做个区分
 */
public abstract class AbstractFactory {

    public abstract Person create();
}
