package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.MaybeImportant;

/**
 * @author SUN
 * @create 2019-04-21 21:04
 * @desc 见名知意
 */
public class ReplaceConstructorWithFactoryMethod extends AbstractIdeaRefactoralbe implements MaybeImportant {

    private String name;
    private int age;

    private ReplaceConstructorWithFactoryMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static ReplaceConstructorWithFactoryMethod createWithNameAndAge(String name, int age) {
        return new ReplaceConstructorWithFactoryMethod(name, age);
    }

    @Override
    String getRefactoringMethod() {
        return null;
    }
}
