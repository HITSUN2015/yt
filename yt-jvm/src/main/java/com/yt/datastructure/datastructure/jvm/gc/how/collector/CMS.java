package com.yt.datastructure.datastructure.jvm.gc.how.collector;/**
 * Created by SUN on 19/3/11.
 */

import com.yt.datastructure.datastructure.jvm.gc.how.AimType;
import com.yt.datastructure.datastructure.jvm.gc.how.acpect.Aim;
import com.yt.datastructure.datastructure.jvm.gc.how.arithmetic.MarkSweep;

/**
 * @author SUN
 * @create 2019-03-11 下午9:42
 * @desc
 *
 * 1.应用:互联网站、B/S系统的服务端
 * 2.缺点:
 *  1)CPU少时,用户程序影响大(并发性降低)
 *  2)
 */
public class CMS implements Aim, MarkSweep {

    @Override
    public AimType getAim() {
        return AimType.WorldStopTime;
    }

    /**
     * 1.mark GC root 直接关联的对象
     * 2.fast
     * 3.stop the world
     */
    public void initialMark_1() {

    }

    /**
     * GC tracing
     */
    public void concurrentMark_2() {

    }

    /**
     * 1.修整 concurrentMark 与用户线程 并发时,变动的引用对象
     * 2.大于initialMark,远小于concurrentMark
     * 3.stop the world
     */
    public void remark_3() {

    }

    public void concurrentSweep_4() {

    }
}
