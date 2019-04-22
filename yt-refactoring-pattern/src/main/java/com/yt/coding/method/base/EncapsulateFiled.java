package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 */
public class EncapsulateFiled extends AbstractRefactorable {
    @Override
    public String motivation() {
        return "这个动机，解释了封装的意义" +
                "封装（数据隐藏）" +
                "如果是public的：数据被修改时，对象毫无察觉：数据 和 行为(更改数据的各种逻辑) 分开了" +
                "如果在一起,行为变更时,只需要找一个地方,而不是shotGun(这里作者强调的不是那种set字段,而是拥有业务逻辑的对属性的赋值)" +
                "";
    }

    /**
     * 提供访问设置方法,更改调用,设置private
     */
    @Override
    public void action() {

    }

    @Override
    public int page() {
        return 206;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
