package com.yt.coding.method.base.condition;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:50
 * @desc
 */
public class ConsolidateDuplicateConditionalFragments extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "在条件表达式的每个分支上由着相同的一段代码";
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
