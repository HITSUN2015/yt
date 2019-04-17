package com.yt.coding.method.base;/**
 * Created by SUN on 19/4/16.
 */

/**
 * @author SUN
 * @create 2019-04-16 下午9:47
 * @desc
 */
public class ExtractMethod extends AbstractRefactorable implements Refactorable{


    @Override
    public String motivation() {
        return null;
    }

    /**
     * 把一部分代码 放到这个类的新的方法里
     *       无局部变量:略
     *       只读局部变量,或该变量是个对象:将该变量当参数传入新方法
     *       提炼的代码段需要对变量赋值:提炼代码段之后不用该字段:同上
     *                                 :提炼代码段之后使用该字段:作为新方法返回值
     *                                                          :返回多个值:让每个函数返回一个值:写多个函数
     *                                                                     :返回对象:比较不支持
     *
     * point1:函数名称比代码长也无所谓
     * point2:如果想不出更有意义的名称，就别动
     * point3:通过上面的分析，可以看出，这个方法的难度主要是解决临时变量，所以提供两个消除临时变量的方法：
     *      方法1：{@link ReplaceTempWithQuery}
     *      方法2：{@link ReplaceMethodWithObject}
     * point4:如果抽方法实在太费劲，放弃的话，可以用{@link IntroduceExplainingVariable}
     */
    @Override
    public void action() {}

    @Override
    public int page() {
        return 110;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
