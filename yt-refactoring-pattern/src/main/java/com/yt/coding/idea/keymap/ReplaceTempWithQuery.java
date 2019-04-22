package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-21 20:58
 * @desc 不作用于入参
 * 这应该是处理出现最多次数的方法了。。。
 */
public class ReplaceTempWithQuery extends AbstractIdeaRefactoralbe implements Frequently {
    @Override
    String getRefactoringMethod() {
        return "replace-temp-with-query";
    }

    public void replaceTempWithQuery() {
        String a = "test";
        System.out.println(a + "\n\r");
    }
}
