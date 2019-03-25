package com.yt.datastructure.datastructure.jvm.gc.how.arithmetic;

/**
 * Created by yantong on 2019/3/11.
 *
 * {@link Copying}
 *  1.存活率较高时，就要进行较多的copy
 *  2.空间利用率低
 *  3.效率会降低，而且还得分配担保，需要额外的老年代存储 TODO
 *
 * 方法：只一份空间，先标记，再将所有存活对象向存储空间的前端移动，清空剩余空间
 *
 * 应用：老年代
 */
public interface MarkCompact {
}
