package com.yt.jvm.gc.how.arithmetic;

/**
 * Created by yantong on 2019/3/11.
 *
 * 不足：
 *  1.效率低（both mark and sweep）
 *  2.空间碎片过多：分配大对象时，容易找不到空间而导致需要更多的GC
 */
public interface MarkSweep {
}
