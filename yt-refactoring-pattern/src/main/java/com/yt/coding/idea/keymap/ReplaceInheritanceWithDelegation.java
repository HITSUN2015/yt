package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaRefactorable;
import com.yt.coding.idea.keymap.dimension.MaybeImportant;

/**
 * @author SUN
 * @create 2019-04-21 21:03
 * @desc 强行解除继承关系，用代理拥有父类功能
 *
 *
 */
public class ReplaceInheritanceWithDelegation implements MaybeImportant, IdeaRefactorable {
    private final MyAbstractIdeaRefactoralbe abstractIdeaRefactoralbe = new MyAbstractIdeaRefactoralbe();

    @Override
    public String getInformationUrl() {
        return abstractIdeaRefactoralbe.getInformationUrl();
    }

    String getRefactoringMethod() {
        return abstractIdeaRefactoralbe.getRefactoringMethod();
    }

    private class MyAbstractIdeaRefactoralbe extends AbstractIdeaRefactoralbe {
        @Override
        String getRefactoringMethod() {
            return "replace-inheritance-with-delegation";
        }
    }
}
