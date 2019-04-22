package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-21 21:17
 * @desc 实际是 {@link ExtractMethod} 等方法的 逆操作
 *
 * 个人认为这个方法的使用是：
 *  1.有些类或方法确实太简单，inline化简代码
 *  2.可能有些复杂的操作过程：先调动了{@link ExtractIntoClassMethodObject} 再调用 {@link Inline} 来梳理代码
 */
public class Inline extends AbstractIdeaRefactoralbe implements IdeaMostPopular {
    @Override
    String getRefactoringMethod() {
        return "inline";
    }
}
