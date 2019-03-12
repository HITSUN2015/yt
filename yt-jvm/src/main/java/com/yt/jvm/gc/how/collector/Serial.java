package com.yt.jvm.gc.how.collector;/**
 * Created by SUN on 19/3/11.
 */

import com.yt.jvm.gc.how.arithmetic.Copying;

/**
 * @author SUN
 * @create 2019-03-11 下午9:40
 * @desc
 *
 * 1.单线程,阻塞所有用户线程
 *
 * 2.应用:基本就是给32位client 模式的jvm 单核CPU 使用 相关见《深入理解JAVA虚拟机》P77
 *
 * 3.几十到一两百MB的新生代,gc一次几十到一百多ms,可以接受
 */
public class Serial implements Copying{

}
