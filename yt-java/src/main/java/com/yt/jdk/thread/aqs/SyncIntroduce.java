package com.yt.jdk.thread.aqs;

/**
 * @author SUN
 * @create 2019-03-27 下午9:24
 * @desc
 *
 * 同步器 获取锁方法的几个维度:
 *                      {@link java.util.concurrent.Semaphore}
 * 1.可中断
 *   不可终端            acquierUninterruptibly()
 * 2.阻塞                acquire()
 *   非阻塞              tryAcquire()
 * 3.阻塞-阻塞时间        tryAcquire(timeout,TimeUnit)
 *
 * 释放:                 release()
 */
public interface SyncIntroduce {
}
