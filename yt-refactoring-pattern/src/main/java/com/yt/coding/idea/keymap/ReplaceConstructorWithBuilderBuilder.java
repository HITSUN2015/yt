package com.yt.coding.idea.keymap;

public class ReplaceConstructorWithBuilderBuilder {
    private String name;
    private int age;

    public ReplaceConstructorWithBuilderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ReplaceConstructorWithBuilderBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ReplaceConstructorWithBuilder createReplaceConstructorWithBuilder() {
        return new ReplaceConstructorWithBuilder(name, age);
    }
}