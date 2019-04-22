package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-21 21:21
 * @desc 本身就有getterSetter 快捷键
 *       TODO 而且lombok插件有特殊支持
 */
public class EncapsulateFields extends AbstractIdeaRefactoralbe implements Rarely {
    @Override
    String getRefactoringMethod() {
        return "encapsulate-fields";
    }
}
