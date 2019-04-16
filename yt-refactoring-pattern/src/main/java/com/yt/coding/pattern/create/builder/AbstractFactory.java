package com.yt.coding.pattern.create.builder;

import com.yt.coding.pattern.create.instance.Person;

/**
 * Created by yantong on 2019/3/22.
 *
 * Builder 模式
 *
 * 我把builder的Person 实体类 换成了 接口
 *
 * 我把这个方法 写成 工厂的 方法，是为了方便
 * 理解 建造者模式 和工厂 模式 有什么区别
 *
 * 区别1：这个工厂 不仅有 对象的构造方法 还有 对象 属性的构造方法
 * 区别2：对 构造工厂的 调用 又进行了一次封装 {@link PersonDirector}
 *        个人 认为 导致这个变化的原因 正是又第一个 区别构成的：
 *              普通的工厂方法，只需要调用 构造方法 {@link com.yt.coding.pattern.create.factory.factoryMethod.AbstractFactory#create()}
 *              而 由于 多了对象属性的构造，会使得代码冗长（属性较多时），所以为了让调用方再化简，就把这一坨 封在{@link PersonDirector}里
 * 以上只是 从 代码编写层面来看的
 *
 * 然后 从 功能上来理解这件事：
 *      把 对象的构造方法 和 属性的构造方法 全交给一个单独的类来管理：
 *      这里这样来想：一大堆方法在一起 可以有什么自由度。。。：顺序
 *      优点：对象属性的构建顺序，可能会改变对象的行为，提供了自由度
 *            提供参数默认值（不用在 写在通用代码里。。。）
 */
public interface AbstractFactory {

    void buildName();

    Person buildPerson();

}
