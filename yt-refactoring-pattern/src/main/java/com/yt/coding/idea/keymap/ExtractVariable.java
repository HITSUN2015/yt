package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.ExtractVariableDemo;
import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-22 下午2:51
 * @desc 当前方法内提取变量
 *          1.如果没有选定，则在光标所在行，选择变量
 *          2.确定查找到的所有相同值，是否全部替换为变量
 * {@link ExtractVariableDemo}
 */
public class ExtractVariable extends AbstractIdeaRefactoralbe implements Frequently {
    @Override
    String getRefactoringMethod() {
        return "extract-variable";
    }

    public void extractVariable() {
        System.out.println(1 + 1 + 1);
    }


    /**
     * TODO: 19/4/22 我这里尝试没成功，但是我认为这个看你不怎么常用
     * @param str
     */
    public void extractFunctionalVariable(String str) {
        System.out.println(str + "test");
    }
}
