package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaRefactorable;

/**
 * @author SUN
 * @create 2019-04-21 21:10
 * @desc
 */
public abstract class AbstractIdeaRefactoralbe implements IdeaRefactorable {

    private String version = "2019.1";

    @Override
    public String getInformationUrl() {
        return String.format("https://www.jetbrains.com/help/idea/%s/%s.html", version, getRefactoringMethod());
    }

    protected abstract String getRefactoringMethod();
}
