package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-21 21:19
 * @desc 这个方法 理解起来 可能有点歧义
 *      他的目的是在指定范围内，找到该方法或常量可以替换的位置
 *      而不是 根据一块代码，去找相同的diam
 *          如果要实现这个需求:将指定代码用 {@link ExtractMethod} 抽出方法A 再全文对A {@link FindAndReplaceCodeDuplicates}
 *
 * {@link com.yt.coding.idea.keymap.demo.FindAndReplaceCodeDuplicatesDemo}
 */
public class FindAndReplaceCodeDuplicates extends AbstractIdeaRefactoralbe implements Frequently {
    @Override
    String getRefactoringMethod() {
        return "find-and-replace-code-duplicates";
    }

    public void FindAndReplaceCodeDuplicates() {
        System.out.println(getSum(1, 2));
    }

    public int getSum(int a, int b) {
        return a + b;
    }
}
