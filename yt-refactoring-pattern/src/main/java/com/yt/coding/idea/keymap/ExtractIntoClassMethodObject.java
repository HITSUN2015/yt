package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.ExtractIntoClassMethodObjectDemo;

/**
 * @author SUN
 * @create 2019-04-22 下午3:49
 * @desc {@link ExtractIntoClassMethodObjectDemo}
 */
public class ExtractIntoClassMethodObject extends AbstractIdeaRefactoralbe{

    @Override
    String getRefactoringMethod() {
        return "extract-into-class-refactorings";
    }

    public void extractIntoClassMethodObject(int i, String s, String test) {
        final String param = "param";
        new InnerMethodObject(i, s, test, param).invoke();
    }

    private class InnerMethodObject {
        private int i;
        private String s;
        private String test;
        private String param;

        public InnerMethodObject(int i, String s, String test, String param) {
            this.i = i;
            this.s = s;
            this.test = test;
            this.param = param;
        }

        public void invoke() {
            System.out.println(i + s + test + param);
        }
    }
}
