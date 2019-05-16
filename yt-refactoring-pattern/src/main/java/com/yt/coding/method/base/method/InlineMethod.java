package com.yt.coding.method.base.method;

import com.yt.coding.method.base.AbstractRefactorable;

/**
 * Created by yantong on 2019/4/17.
 *
 * 我个人理解，最好不要把这个方法翻译成 内联函数，就是OneLine函数比较好。。。
 */
public class InlineMethod extends AbstractRefactorable {

    @Override
    public String motivation() {
        return "内部代码与函数名称同样清晰易读";
    }

    /**
     * 1.检查函数，确定其不具备多态性：如果没有这个函数，子类无法复写
     * 2.找出函数调用，全部换成函数本体
     * 3.删除该函数
     *
     * point：如果遇到了比较复杂的，难以用代码直接替换函数的时候：往往不应该用inlineMethod
     */
    @Override
    public void action() {

    }

    @Override
    public int page() {
        return 117;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
