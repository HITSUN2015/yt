package com.yt.interview.tou;/**
 * Created by SUN on 19/3/25.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN
 * @create 2019-03-25 下午9:03
 * @desc
 */
public class Producer implements Runnable {


    private List<Integer> jobs = new ArrayList<>();

    private static final int MAX_JOB_SIZE = 1000;

    @Override
    public void run() {
        while (true) {
            addJob();
        }
    }

    public synchronized void addJob() {
        if (jobs.size() >= MAX_JOB_SIZE) {

        }
        jobs.add(2);
    }

    /**
     * url请求
     * dns协议
     * uuid生成   扩容
     * producer 状态变更锁
     * redis
     * 交付机制
     * table hash冲突
     * hashTable 扩容
     * hash值如何生成
     * kafka 对比
     * cookie、session
     * nginx 原理
     * nginx 策略
     */
}
