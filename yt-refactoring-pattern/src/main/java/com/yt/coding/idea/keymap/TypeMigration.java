package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-21 20:29
 * @desc TODO
 */
public class TypeMigration extends AbstractIdeaRefactoralbe implements Frequently {

    private int[] value;

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    String getRefactoringMethod() {
        return "type-migration";
    }
}
