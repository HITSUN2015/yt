package com.yt.coding.pattern.action.chainOfResponsibility.bad;

import java.util.Random;

/**
 * @author SUN
 * @create 2019-04-28 下午9:59
 * @desc
 */
public class Handler {

    public boolean handle(Event event) {
        System.out.println("handler[" + this + "] event[" + event + ']');
        return new Random().nextBoolean();
    }

}
