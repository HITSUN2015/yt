package com.yt.design.pattern.action.template;/**
 * Created by SUN on 19/3/23.
 */

/**
 * @author SUN
 * @create 2019-03-23 下午9:29
 * @desc
 */
public class Football extends Template {

    @Override
    void endPlay() {
        System.out.println("Football Template Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Template Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Template Started. Enjoy the game!");
    }
}