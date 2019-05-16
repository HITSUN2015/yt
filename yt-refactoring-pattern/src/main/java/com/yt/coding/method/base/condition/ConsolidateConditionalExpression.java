package com.yt.coding.method.base.condition;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:47
 * @desc
 */
public class ConsolidateConditionalExpression extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "一系列条件 得到相同结果" +
                "如果这些条件确实应该独立，就不要合并";
    }

    @Override
    public void action() {

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
