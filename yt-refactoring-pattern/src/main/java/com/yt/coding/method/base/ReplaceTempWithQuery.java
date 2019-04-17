package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 *
 * 我的理解是，
 */
public class ReplaceTempWithQuery implements Refactorable {
    @Override
    public String motivation() {
        return "如果这个临时变量是这个对象是比较重要的概念，就把他变成一个函数来获取\n" +
                "有一个比较重要的情况是，可能一开始你并不认为他是个概念，所以，这个方法可以帮你发现概念" +
                "优点主要体现在有多个函数，会用到这个变量表达的概念，这里可以看出，这是一个非属性表达的property概念";
    }

    /**
     * 临时变量的源头：1）对象的属性，2）全局变量，3）方法内临时变量，4）方法的入参
     * 1），2）可以很简单的成方法
     * 3）递归变为1），2）
     * 4）TODO
     *
     * 1.如果变量被赋值多次：{@link SplitTemporaryVariable}
     * 2.如果对变量的赋值函数本身并非单纯的查询（含副作用：会修改任意一个对象的内容）：{@link SeparateQueryFromModifier}
     * 2.新建private函数 以后发现可以复用，可以再把权限打开
     *
     */
    @Override
    public void action() {

    }

    @Override
    public Object badCode(Object... params) {
        return null;
    }

    @Override
    public Object goodCode(Object... params) {
        return null;
    }

    @Override
    public int page() {
        return 120;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
