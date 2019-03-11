package com.yt.jvm.gc.how.collector;/**
 * Created by SUN on 19/3/11.
 */

import com.yt.jvm.gc.how.AimType;
import com.yt.jvm.gc.how.acpect.Aim;
import com.yt.jvm.gc.how.arithmetic.Copying;

/**
 * @author SUN
 * @create 2019-03-11 下午9:41
 * @desc
 */
public class ParallelScavenge implements Copying, Aim {

    @Override
    public AimType getAim() {
        return AimType.Throughput;
    }
}
