package com.yt.coding.method.base;

/**
 * Created by yantong on 2019/4/17.
 *
 * 替换算法
 */
public class SubstituteAlgorithm extends AbstractRefactorable implements Refactorable {

    @Override
    public String motivation() {
        return "随着对问题有了更多理解，发现有更简单的解决方案" +
                "还可能，你开始使用了一些程序库" +
                "使用这种方法之前，需要确定原函数已经尽可能的分解了，替换一个复杂的算法是很困难的";
    }

    @Override
    public void action() {
        //略
    }

    @Override
    public int page() {
        return 139;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
