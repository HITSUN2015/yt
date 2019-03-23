package com.yt.design.pattern.action.strategy;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:39
 * @desc
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
