package com.yt.coding.pattern.create.abstractFactory.red;

import com.yt.coding.pattern.create.demo.AbstractRoom;
import com.yt.coding.pattern.create.demo.Door;

/**
 * @author SUN
 * @create 2019-04-23 下午3:52
 * @desc
 */
public class RedDoor extends Door {
    public RedDoor(AbstractRoom r1, AbstractRoom r2) {
        super(r1, r2);
    }
}
