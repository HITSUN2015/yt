package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Rarely;

/**
 * @author SUN
 * @create 2019-04-22 下午1:28
 * @desc 从一个类里，提炼出一个接口
 *       个人感觉这个方法过于复杂，如果实际使用，请自行查看extract interface
 */
public class ExtractInterface extends AbstractIdeaRefactoralbe implements Rarely {
    @Override
    String getRefactoringMethod() {
        return "extract-interface";
    }
}
