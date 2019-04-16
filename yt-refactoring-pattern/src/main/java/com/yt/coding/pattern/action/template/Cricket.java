package com.yt.coding.pattern.action.template;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:28
 * @desc
 */
public class Cricket extends Template {

    @Override
    void endPlay() {
        System.out.println("Cricket Template Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Template Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Template Started. Enjoy the game!");
    }
}
