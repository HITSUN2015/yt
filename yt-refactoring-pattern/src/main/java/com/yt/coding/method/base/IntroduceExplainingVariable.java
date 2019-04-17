package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 */
public class IntroduceExplainingVariable extends AbstractRefactorable {
    @Override
    public String motivation() {
        return "主要用于条件分支的逻辑：" +
                "有一个复杂的表达式（看不懂意义的表达式），设个取名字的变量，解释之" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "";
    }

    /**
     * 但是更推荐使用 {@link ExtractMethod},只有当 处理一个拥有大量局部变量的方法
     * {@link ExtractMethod} 比较难时，放弃才用这种方法，
     * 然再用 {@link ReplaceTempWithQuery} 或 {@link ReplaceMethodWithObject} 帮助去掉临时变量
     * 然后再 {@link ExtractMethod}
     * 这个过程中，本方法，可以提供方法名
     *
     * 1.设置个临时变量命名，用表达式赋值
     */
    @Override
    public void action() {

    }

    @Override
    public int page() {
        return 124;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
