package com.yt.coding.method.base.condition;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:44
 * @desc
 */
public class DecomposeConditional extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "复杂的条件逻辑是最长导致复杂度上升的地点之一" +
                "将美国分支条件分解成新函数：清晰表达每个分支意图";
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
