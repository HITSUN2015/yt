package com.yt.coding.method.base;/**
 * Created by SUN on 19/4/16.
 */

/**
 * @author SUN
 * @create 2019-04-16 下午10:09
 * @desc 不要对 参数赋值(如果是对象的话:不要改变参数对象的引用)
 *       就是建立 临时变量
 */
public class RemoveAssignmentsToParameters implements Refactorable{
    @Override
    public String motivation() {
        return "按值 按引用 传递参数的语言上的区别,容易让不清楚的人混淆";
    }

    @Override
    public Object badCode(Object... params) {
        params = new Object[2];//java 按值传递,改变对象的引用,不会改变调用方的变量
        badCodeIntInput(1);
        return null;
    }

    private void badCodeIntInput(int intInput) {
        intInput = 2;
        //code with input
    }

    @Override
    public Object goodCode(Object... params) {
        goodCodeIntInput(1);
        return null;
    }

    private void goodCodeIntInput(int input) {
        int temp = input;
        //code with temp
    }
}
