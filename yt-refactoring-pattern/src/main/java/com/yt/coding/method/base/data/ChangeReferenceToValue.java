package com.yt.coding.method.base.data;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:23
 * @desc
 */
public class ChangeReferenceToValue extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "在分布系统和并发系统中，不可变的值对象特别有用，因为你无需考虑他们的同步问题" +
                "值对象是不可变的。";
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
