package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.ExtractConstantDemo;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 21:20
 * @desc
 */
public class ExtractConstant extends AbstractIdeaRefactoralbe implements IdeaMostPopular {

    private static final String LALA = "lala";
    /**
     * {@link ExtractConstantDemo#extractConstant()}
     * 可以选择放在别的类里
     */
    public void extractConstant() {
        System.out.println(LALA);
    }




    @Override
    String getRefactoringMethod() {
        return "extract-constant";
    }
}
