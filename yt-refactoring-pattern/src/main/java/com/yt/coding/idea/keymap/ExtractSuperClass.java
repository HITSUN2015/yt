package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-22 下午2:40
 * @desc like {@link ExtractInterface}
 */
public class ExtractSuperClass extends AbstractIdeaRefactoralbe implements Rarely {
    @Override
    String getRefactoringMethod() {
        return "extract-superclass";
    }
}
