package com.yt.datastructure.datastructure.jvm.gc.how.collector;/**
 * Created by SUN on 19/3/11.
 */

import com.yt.datastructure.datastructure.jvm.gc.how.AimType;
import com.yt.datastructure.datastructure.jvm.gc.how.acpect.Aim;
import com.yt.datastructure.datastructure.jvm.gc.how.arithmetic.MarkCompact;

/**
 * @author SUN
 * @create 2019-03-11 下午9:42
 * @desc
 *
 * 高吞吐可考虑优先考虑:{@link ParallelScavenge} + {@link ParallelOld}
 */
public class ParallelOld implements MarkCompact , Aim{

    @Override
    public AimType getAim() {
        return AimType.Throughput;
    }
}
