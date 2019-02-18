package com.yt.design.pattern.decorator;


/**
 * Created by yantong on 2019/2/18.
 *
 * 说白了就是：
 * 一开始有一个功能A:
 * 接口：Component
 * 实现类：ConcreteComponent
 *
 * 后来，对接口增加功能
 * 继承的方法是：建立个子类PluginConcreteComponent，继承ConcreteComponent
 * 重写 接口每个方法时，可以先调super。。。再调用新增的方法
 *
 * 这样的话，会造成有个继承链或继承树：
 * eg：业务功能A
 * 想加入日志功能：继承ConcreteComponent，LogPluginConcreteComponent 增加log功能
 * 想加入统计功能：继承ConcreteComponent, StaticPluginConcreteComponent 增加统计功能
 * 想加入权限功能：继承ConcreteComponent, AuthPluginConcreteComponent 增加权限功能
 * 问题来了，如果我想加入 日志、统计、权限的组合功能，怎么搞
 * eg:日志、统计、权限功能：ConcreteComponent->LogPluginConcreteComponent
 *                                           ->StaticLogPluginConcreteComponent
 *                                           ->AuthStaticLogPluginConcreteComponent
 * 这样会有6个子类的继承树
 *
 * 有没有方法，需要哪个功能，就把哪个类的功能加进来这种简单点的实现？
 *
 * 功能的混合：一种是继承、一种是组合
 * 组合的方法是：建立个类PluginComponent 持有Component接口，代用接口方法时，额外调用自己的方法
 * 这样的写法 就比较多了。。。
 * eg：PluginComponent 持有一个list，我们需要什么额外的功能，先调用Component接口基础方法，再遍历调用list中的所有方法
 * ugly包下我实现了下这个。。。客户端代码在DecoratorTest里，
 * 缺点分析：TODO
 * 1.返回值 TODO
 *
 * 如何快速的识别出 装饰者模式：
 * 1.两个类，实现同一个接口
 * 2.有一个类（复合类） 持有另一个类（基类）
 * 3.复合类调用该接口时，调用基类的实现
 *
 * 根据这个 我就写了个最简单的 装饰代码 {@link com.yt.design.pattern.decorator.simplest.SimpleInterface}
 * 但是没有 灵活 选择功能的过程，所以又写了 simpler的代码
 *
 * 可以看出 {@link com.yt.design.pattern.decorator.simpler.CompoundClassA}
 *       和 {@link com.yt.design.pattern.decorator.simpler.CompoundClassB}
 * 有重复的 持有接口的代码，和调用持有对象方法的方法，
 * 简化抽象之，就诞生了我们模式里的 Decorator 抽象类
 */
public interface Introduce {

}
