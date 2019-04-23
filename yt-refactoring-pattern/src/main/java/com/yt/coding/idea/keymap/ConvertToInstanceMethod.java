package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.demo.frequently.ConvertToInstanceMethodDemo;
import com.yt.coding.idea.keymap.dimension.MaybeImportant;

/**
 * @author SUN
 * @create 2019-04-21 21:21
 * @desc
 *      将静态方法 归属于本类或入参对象里
 *      {@link ConvertToInstanceMethodDemo}
 */
public class ConvertToInstanceMethod extends AbstractIdeaRefactoralbe implements MaybeImportant {

    public void method(ClassA classA, String p2, ClassB classB) {
        System.out.println(classA.getClass());
        System.out.println(classB.getClass());
        System.out.println(ClassB.class);
    }

    @Override
    String getRefactoringMethod() {
        return "convert-to-instance-method";
    }

    private void test() {
        method(new ClassA(), null, new ClassB());
    }

    private class ClassA{

    }

    private class ClassB {

    }


}
