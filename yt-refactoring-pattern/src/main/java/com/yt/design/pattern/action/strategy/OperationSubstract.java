package com.yt.design.pattern.action.strategy;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:38
 * @desc
 */
public class OperationSubstract implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}