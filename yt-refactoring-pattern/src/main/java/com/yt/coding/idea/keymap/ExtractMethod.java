package com.yt.coding.idea.keymap;

/**
 * @author SUN
 * @create 2019-04-22 下午1:31
 * @desc
 *
 * 暂时没去想 他的实现规则，demo里我给出了优先级
 *
 * {@link com.yt.coding.idea.keymap.demo.ExtractMethodDemo}
 */
public class ExtractMethod extends AbstractIdeaRefactoralbe {

    private void extractMethodA() {
        int i = 1;
        int i1 = 2;
        System.out.println(getSum(i, i1));
        System.out.println(i + i + (getSum(i1, i1)));
        System.out.println((getSum(i + i, i1 + i1)));
    }

    private int getSum(int i, int i1) {
        return i + i1;
    }

    @Override
    String getRefactoringMethod() {
        return "extract-method";
    }
}
