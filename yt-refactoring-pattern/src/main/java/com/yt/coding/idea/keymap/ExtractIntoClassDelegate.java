package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.ExtractIntoClassDelegateDemo;
import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-22 下午3:28
 * @desc {@link ExtractIntoClassDelegateDemo}
 *      个人认为这个主要就是 把一部分代码移动到新的类里
 *      member不存在的那个类里，需要有另一个类的代理
 */
public class ExtractIntoClassDelegate extends AbstractIdeaRefactoralbe implements Frequently {

    private String str = "str";

    @Override
    String getRefactoringMethod() {
        return "extract-into-class-refactorings";
    }

    public String getStr() {
        return str;
    }


    public static class DelegateForExtractIntoClassDelegate {
        private final ExtractIntoClassDelegate extractIntoClassDelegate;

        public DelegateForExtractIntoClassDelegate(ExtractIntoClassDelegate extractIntoClassDelegate) {
            this.extractIntoClassDelegate = extractIntoClassDelegate;
        }

        public void extractIntoClass() {
            System.out.println(extractIntoClassDelegate.getStr());
        }
    }
}
