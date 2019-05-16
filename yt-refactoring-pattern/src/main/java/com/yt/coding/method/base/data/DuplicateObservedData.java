package com.yt.coding.method.base.data;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:28
 * @desc
 */
public class DuplicateObservedData extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "没有MVC分层";
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
