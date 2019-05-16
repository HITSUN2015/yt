package com.yt.coding.method.base.data;

import com.yt.coding.idea.keymap.AbstractIdeaRefactoralbe;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:08
 * @desc
 */
public class SelfEncapsulateField extends AbstractIdeaRefactoralbe implements Refactorable {
    @Override
    public String motivation() {
        return "两派：类内部是否也用函数来访问数据" +
                "间接访问变量的好处：子类可以通过覆写一个函数而改变获取数据的途径，还支持更灵活的数据管理方式（延迟初始化）" +
                "直接访问变量的好处：易读" +
                "" +
                "可以采用团队大多数做法，或用直接直到带来麻烦就改完间接" +
                "" +
                "构造函数 调用设值函数：直接访问字段或init函数，";// TODO: SUN 2019-05-13 构造函数init函数替代设值函数
    }

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
        return 0;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    protected String getRefactoringMethod() {
        return null;
    }
}
