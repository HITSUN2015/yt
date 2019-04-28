package com.yt.coding.pattern.create.abstractFactory.green;

import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Door;

/**
 * @author SUN
 * @create 2019-04-23 下午3:52
 * @desc
 */
public class GreenDoor extends Door {
    public GreenDoor(AbstractRoom r1, AbstractRoom r2) {
        super(r1, r2);
    }
}
