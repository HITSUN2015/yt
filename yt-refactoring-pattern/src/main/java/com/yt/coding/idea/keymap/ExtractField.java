package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;
import com.yt.coding.idea.keymap.dimension.IdeaMostPopular;

/**
 * @author SUN
 * @create 2019-04-22 下午1:26
 * @desc
 */
public class ExtractField extends AbstractIdeaRefactoralbe implements Frequently, IdeaMostPopular {

    private String extractField = "str";
    /**
     * {@link com.yt.coding.idea.keymap.demo.ExtractFieldDemo#extractField()}
     * 可以选择初始化位置 值为当前表达式的值
     *  如果表达式是变量，
     *      1）当前方法体里
     *  如果是常量：
     *      1）当前方法体里
     *      2）属性里
     *      3）构造函数
     */
    public void extractField() {
        System.out.println(extractField);
    }

    @Override
    String getRefactoringMethod() {
        return "extract-field";
    }
}
