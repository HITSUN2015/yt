package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 */
public class EncapsulateFiled extends AbstractRefactorable {
    @Override
    public String motivation() {
        return "这个动机，解释了封装的意义" +
                "封装（数据隐藏）" +
                "如果是public的：数据被修改时，对象毫无察觉：数据和行为 分开了";
    }

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
