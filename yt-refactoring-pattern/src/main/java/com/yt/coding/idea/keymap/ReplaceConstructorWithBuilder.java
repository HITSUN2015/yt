package com.yt.coding.idea.keymap;

import com.yt.coding.idea.keymap.dimension.MaybeImportant;

/**
 * @author SUN
 * @create 2019-04-21 21:04
 * @desc 点击构造函数 refactor
 */
public class ReplaceConstructorWithBuilder extends AbstractIdeaRefactoralbe implements MaybeImportant {

    private String name;

    private int age;

    public ReplaceConstructorWithBuilder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    String getRefactoringMethod() {
        return "replace-constructor-with-builder";
    }

    public void demo() {
        ReplaceConstructorWithBuilderBuilder builder = new ReplaceConstructorWithBuilderBuilder();
        final ReplaceConstructorWithBuilder sun = builder.setName("SUN").setAge(110).createReplaceConstructorWithBuilder();
    }
}
