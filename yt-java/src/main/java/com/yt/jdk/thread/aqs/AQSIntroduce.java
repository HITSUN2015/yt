package com.yt.jdk.thread.aqs;/**
 * Created by SUN on 19/3/28.
 */

/**
 * @author SUN
 * @create 2019-03-28 下午9:16
 * @desc
 *
 * 了解一下:
 *   1.Doug Lea
 *   2.JSR-166
 *   3.《Scalable Queue-Based Spin Locks with Timeout》
 *     《Queue locks on cache coherent multiprocessors》
 *     《Building FIFO and priority-queueing spin locks from atomic swap》
 *
 * 原理:
 *   同步器的主要操作:
 *     【acquire】
 *   1    while (synchronization state does not allow acquire) {
 *   2         enqueue current thread if not already queued;
 *   3         possibly block current thread;
 *   4    }
 *   5    dequeue current thread if it was queued;
 *
 *     【release】
 *   6    update synchronization state;
 *   7    if (state may permit a blocked thread to acquire)
 *   8    unblock one or more queued threads;
 *
 *   1、6、7   :同步器需要 支持状态维护 {@link AQSState}
 *   2、5      :同步器需要 维护等待队列 {@link WaitingQueue}
 *   3、8      :同步器需要 线程阻塞与释放
 *
 *   {@link java.util.concurrent.locks.AbstractQueuedSynchronizer}
 */
public interface AQSIntroduce {

}
