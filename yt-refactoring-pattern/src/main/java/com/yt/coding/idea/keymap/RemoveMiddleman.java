package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-21 21:05
 * @desc TODO demo中两个类互相持有有的蒙
 *            实际感觉应该是 把中间对象的方法，提到最外层的调用处
 */
public class RemoveMiddleman extends AbstractIdeaRefactoralbe implements Rarely {
    @Override
    String getRefactoringMethod() {
        return "remove-middleman";
    }
}
