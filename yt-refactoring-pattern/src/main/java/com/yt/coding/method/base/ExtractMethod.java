package com.yt.coding.method.base;/**
 * Created by SUN on 19/4/16.
 */

/**
 * @author SUN
 * @create 2019-04-16 下午9:47
 * @desc 把一部分代码 放到这个类的新的方法里
 *       无局部变量:略
 *       只读局部变量,或该变量是个对象:将该变量当参数传入新方法
 *       提炼的代码段需要对变量赋值:提炼代码段之后不用该字段:同上
 *                              :提炼代码段之后使用该字段:作为新方法返回值
 *                                                    :返回多个值:让每个函数返回一个值:写多个函数
 *                                                              :返回对象:比较不支持
 *
 */
public class ExtractMethod implements Refactorable{


    @Override
    public String motivation() {
        return null;
    }

    @Override
    public Object badCode(Object... params) {
        return null;
    }

    @Override
    public Object goodCode(Object... params) {
        return null;
    }
}
