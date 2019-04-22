package com.yt.coding.idea.keymap.demo;

/**
 * @author SUN
 * @create 2019-04-22 下午4:16
 * @desc {@link com.yt.coding.idea.keymap.ExtractIntoClassParamObject}
 */
public class ExtractIntoClassParamObjectDemo {

    public void extractIntoClassMethodObject(int i, String s, String test) {
        final String param = "param";
        System.out.println(i + s + test + param);
    }
}
