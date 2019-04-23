package com.yt.coding.idea.keymap.demo.frequently;

/**
 * @author SUN
 * @create 2019-04-22 下午7:46
 * @desc {@link com.yt.coding.idea.keymap.SafeDelete}
 */
public class SafeDeleteDemo {

    private void deleteParameter(int i) {
        System.out.println(i);
        level1();
    }

    private void level1() {
        level2();
    }

    private void level2() {
        System.out.println();
    }

    private void level12() {
        level2();
    }
}
