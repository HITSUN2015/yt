package com.yt.coding.method.base;


/**
 * Created by yantong on 2019/4/17.
 *
 * 并发：关于包级别， 并不理解
 */
public class SeparateQueryFromModifier implements Refactorable {


    @Override
    public String motivation() {
        // TODO: 2019/4/17
        return null;
    }

    /**
     * 新建一个查询函数，与原函数 返回值一样，如果调用者 把这个查询结果赋值给了某个临时变量，应该能去掉该变量
     *                 原函数 严格 不 返回值
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
        return 0;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
