package com.yt.jvm.gc.how;

/**
 * Created by SUN on 19/3/11.
 *
 * Throughput=运行用户代码时间/(运行用户代码时间 + 垃圾收集时间)
 *
 * WorldStopTime    小->     用户交互体验好
 * Throughput       高->     后台运算快
 */
public enum AimType {
    Throughput,WorldStopTime
}
