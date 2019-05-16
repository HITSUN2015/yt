package com.yt.coding.method.base.data;

import com.yt.coding.method.base.AbstractRefactorable;
import com.yt.coding.method.base.Refactorable;

/**
 * @author SUN
 * @create 2019-05-13 14:37
 * @desc
 */
public class EncapsulateCollection extends AbstractRefactorable implements Refactorable {
    @Override
    public String motivation() {
        return "取值函数 不该返回集合自身，这回让用户得意修改集合内容而拥有者却一无所知";// TODO: SUN 2019-05-13
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
