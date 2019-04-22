package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaRefactorable;

/**
 * @author SUN
 * @create 2019-04-21 21:09
 * @desc 见名知意 主要遍历是解决调用链的变更
 */
public class MakeStatic extends AbstractIdeaRefactoralbe implements IdeaRefactorable {

    @Override
    String getRefactoringMethod() {
        return "make-method-static";
    }

    public String concatA(String source) {
        return source + "a";
    }

    public String concatAandB(String source) {
        return concatA(source) + "B";
    }
}
