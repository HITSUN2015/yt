package com.yt.datastructure.datastructure.design.pattern.singleton;/**
 * Created by SUN on 19/3/3.
 */

import java.time.Instant;
import java.util.Date;

/**
 * @author SUN
 * @create 2019-03-03 下午4:16
 * @desc
 */
public class Instance {

    public Instance() {
        System.out.println(Date.from(Instant.now()));
    }
}
