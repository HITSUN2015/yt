package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 21:05
 * @desc 见名知意 平时应该经常用了
 */
public class Rename extends AbstractIdeaRefactoralbe implements Frequently, IdeaMostPopular {
    @Override
    String getRefactoringMethod() {
        return "rename-refactorings";
    }
}
