package com.yt.design.pattern.action.strategy;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:37
 * @desc    这个模式 就是 为接口提供了一个容器,不同的实现类,装在容器里
 *          工厂模式是 返回 实现类对象
 *          策略模式是 直接用工厂
 */
public interface Strategy {

    public int doOperation(int num1, int num2);
}