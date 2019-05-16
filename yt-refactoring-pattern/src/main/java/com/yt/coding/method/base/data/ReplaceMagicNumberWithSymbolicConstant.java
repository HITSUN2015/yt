package com.yt.coding.method.base.data;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:34
 * @desc
 */
public class ReplaceMagicNumberWithSymbolicConstant extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return null;
    }

    @Override
    public void action() {
        //如果magic number是类型码，请用enum
        //如果是数组长度 请用 array.length
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
