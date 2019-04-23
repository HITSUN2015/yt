package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.ChangeSignatureDemo;
import com.yt.coding.idea.keymap.dimension.Frequently;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 上午11:35
 * @desc
 *
 * 功能主义体现在，修改一处，自动修改对应代码
 *
 * 修改类的签名，主要用来修改泛型及泛型约束，并给调用类设置默认的类型 {@link #changeClassSignature()}
 *      个人感觉这个方法，并不常用，一个类的泛型，在设计时，应该就写好了
 *
 * 修改方法的签名 {@link #changeMethodSignature()}
 *  只有新增变量或异常才可以选择 propagate：修改调用者链
 *
 * 除了修改，还可以选择委托给一个新生成的方法 delegate
 *
 * {@link ChangeSignatureDemo}
 */
public class ChangeSignature extends AbstractIdeaRefactoralbe implements Frequently, IdeaMostPopular {


    @Override
    String getRefactoringMethod() {
        return "change-signature";
    }

    /**
     * 1.光标放在要修改的类的类名上
     * 2.refactor->Change Signature
     */
    public void changeClassSignature() {
        ChangeSignature changeSignature = new ChangeSignature();
    }

    public void changeMethodSignature() {
        changeMethodSignature(1000);
    }

    public void changeMethodSignature(int timeout) {
    }

    public void level1() {
        changeMethodSignature();
    }

    public void level2(String method) {
        level1();
    }

    public void level3() {
        level2("PUT");
    }
}
