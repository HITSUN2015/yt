package com.yt.design.pattern.structure.proxy;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:08
 * @desc 代理模式 感觉有点 太像 {@link com.yt.design.pattern.structure.decorator.simplest.SimpleInterface}
 *
 * 只不过,装饰着模式,是由开发人员编程,运行时选择新增的代码
 *
 * 而 代理模式,是在 编译器,决定了新增代码
 */
public interface ProxyInterface {

    void marry();
}
