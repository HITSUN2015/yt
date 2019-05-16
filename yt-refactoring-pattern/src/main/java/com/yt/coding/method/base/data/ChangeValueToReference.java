package com.yt.coding.method.base.data;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:18
 * @desc
 */
public class ChangeValueToReference extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "一个对象存在一些课修改数据，对任一对象的修改，都能影响到所有引用此对象的地方，需要将这个对象改为引用";
    }

    @Override
    public void action() {

    }

    @Override
    public int page() {
        return 179;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
