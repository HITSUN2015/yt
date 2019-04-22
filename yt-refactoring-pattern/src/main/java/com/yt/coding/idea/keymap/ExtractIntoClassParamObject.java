package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.Frequently;

/**
 * @author SUN
 * @create 2019-04-22 下午4:12
 * @desc {@link com.yt.coding.idea.keymap.demo.ExtractIntoClassMethodObjectDemo}
 */
public class ExtractIntoClassParamObject extends AbstractIdeaRefactoralbe implements Frequently {
    @Override
    String getRefactoringMethod() {
        return "extract-into-class-refactorings";
    }

    public void extractIntoClassMethodObject(InnerParamObject innerParamObject) {
        final String param = "param";
        System.out.println(innerParamObject.getI() + innerParamObject.getS() + innerParamObject.getTest() + param);
    }

    private static class InnerParamObject {
        private final int i;
        private final String s;
        private final String test;

        private InnerParamObject(int i, String s, String test) {
            this.i = i;
            this.s = s;
            this.test = test;
        }

        public int getI() {
            return i;
        }

        public String getS() {
            return s;
        }

        public String getTest() {
            return test;
        }
    }
}
