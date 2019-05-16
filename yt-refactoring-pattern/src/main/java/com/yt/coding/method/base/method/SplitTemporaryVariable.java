package com.yt.coding.method.base.method;

import com.yt.coding.method.base.Refactorable;

/**
 * Created by yantong on 2019/4/17.
 *
 * deal with {@link com.yt.coding.method.base.model.ParamType#WRITE_MORE_THAN_ONE_TIME}
 *      but not {@link com.yt.coding.method.base.model.ParamType#FOR_LOOP}
 *      nor {@link com.yt.coding.method.base.model.ParamType#COLLECT_RETURN}
 */
public class SplitTemporaryVariable implements Refactorable {

    @Override
    public String motivation() {
        return null;
    }

    /**
     "如果一个临时变量除了上述情况，还被赋值多次，就说明他担负了一个以上的责任" +
     "主要解决，被赋值多次的问题：每次赋值，给予新的临时变量" +
     "这里有个重命名的操作，需要考虑顺序：实际是按变量的赋值行，把代码分块，每块对该变量的命名需要不一样" +
     "一种是从下往上：由于上面的变量名称还是有意义，ide不会提示红色" +
     "所以从上面往下修改名字" +
     "必要的话 可以 加上 final 关键字"

     如果遇到循环中对多个变量赋值，则每个变量用一次循环，性能问题：再寻找更好的性能优化方案
     */
    @Override
    public void action() {
    }

    @Override
    public Object badCode(Object... params) {
        //略
        return null;
    }

    @Override
    public Object goodCode(Object... params) {
        //略
        return null;
    }

    @Override
    public int page() {
        return 128;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
