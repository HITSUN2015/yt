package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 21:06
 * @desc 调用这个方法 可能 需要 先变成 static
 */
public class MoveAndCopy extends AbstractIdeaRefactoralbe implements Frequently, IdeaMostPopular {

    private static String test = "test";

    public static void println() {
        System.out.println(test);
    }

    @Override
    String getRefactoringMethod() {
        return "move-refactorings";
    }


    public static class InnerClass {

        public InnerClass() {
        }

    }
}
