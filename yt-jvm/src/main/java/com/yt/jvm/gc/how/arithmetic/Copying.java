package com.yt.jvm.gc.how.arithmetic;

/**
 * Created by yantong on 2019/3/11.
 *
 * 书上说是为了解决效率问题，可能是描述对象是java程序
 *
 * 我这里认为这种方法是 解决 MarkSweep的空间碎片问题
 *
 * 方法：将空间平分为两份，当一份用满时，将存活的对象在另一份空间里复制一份，再改变堆指针。
 *
 * 优点：实现简单，运行高效
 * 缺点：内存降为原来的一半
 *
 * 应用：商业JVM用这个方法 回收 新生代 TODO
 */
public interface Copying {
}
