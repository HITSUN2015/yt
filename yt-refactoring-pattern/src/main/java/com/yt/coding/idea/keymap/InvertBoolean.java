package com.yt.coding.idea.keymap;

/**
 * @author SUN
 * @create 2019-04-21 21:17
 * @desc 这个方法的应用场景应该是去掉 not等词开头且返回boolean的方法的重构上
 */
public class InvertBoolean extends AbstractIdeaRefactoralbe {
    @Override
    String getRefactoringMethod() {
        return "invert-boolean-refactoring";
    }

    public boolean isNotBoolean(Object o) {
        if (null == o) {
            return false;
        }
        if (o instanceof Boolean) {
            return true;
        }
        return false;
    }
}
