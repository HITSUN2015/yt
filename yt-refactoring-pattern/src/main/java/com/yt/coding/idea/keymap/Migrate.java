package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaRefactorable;

/**
 * @author SUN
 * @create 2019-04-21 21:07
 * @desc TODO 好像是用来架包版本升级的
 */
public class Migrate implements IdeaRefactorable {
    @Override
    public String getInformationUrl() {
        return "migrate";
    }
}
