package com.yt.jvm.gc.how;

/**
 * Created by yantong on 2019/3/11.
 *
 * 原理：根据对象存活周期的不同 将 内存 划分为几块。根据各自特定，用不同算法处理
 *
 * eg：新生代：死的非常快：{@link Copying}
 *     老年代：存活周期长，没有额外空间来担保：{@link MarkSweep} or {@link MarkCompact}
 *
 * 应用：当前商业虚拟机
 */
public interface GenerationalCollection {
}
