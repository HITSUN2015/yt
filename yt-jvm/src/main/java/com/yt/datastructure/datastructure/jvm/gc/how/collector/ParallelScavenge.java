package com.yt.datastructure.datastructure.jvm.gc.how.collector;/**
 * Created by SUN on 19/3/11.
 */

import com.yt.datastructure.datastructure.jvm.gc.how.AimType;
import com.yt.datastructure.datastructure.jvm.gc.how.arithmetic.Copying;
import com.yt.datastructure.datastructure.jvm.gc.how.acpect.Aim;

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
