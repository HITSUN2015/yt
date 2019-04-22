package com.yt.coding.idea.keymap.demo;

/**
 * @author SUN
 * @create 2019-04-22 上午10:13
 * @desc {@link com.yt.coding.idea.keymap.ChangeSignature}
 */
public class ChangeSignatureDemo {

    public void changeClassSignature() {
        ChangeSignatureDemo changeSignatureDemo = new ChangeSignatureDemo();
    }

    public void changeMethodSignature() {
    }

    public void level1() {
        changeMethodSignature();
    }

    public void level2() {
        level1();
    }

    public void level3() {
        level2();
    }
}
