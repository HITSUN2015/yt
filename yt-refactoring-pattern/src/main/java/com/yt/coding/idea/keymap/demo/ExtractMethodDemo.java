package com.yt.coding.idea.keymap.demo;

/**
 * @author SUN
 * @create 2019-04-22 下午1:42
 * @desc {@link com.yt.coding.idea.keymap.ExtractMethod}
 */
public class ExtractMethodDemo {

    private void extractMethodA() {
        int i = 1;
        int i1 = 2;
        System.out.println(i + i1);
        System.out.println(i + i + (i1 + i1));
        System.out.println(((i + i) + (i1 + i1)));
    }
}
