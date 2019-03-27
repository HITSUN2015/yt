package com.yt.jdk.thread;


import com.yt.jdk.thread.modal.Info;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/2/15.
 */

public class Synchronize implements Signal{

    /**
     * 这个关键字 锁住的是 Synchronize 这个对象，而非传入的 info对象
     * 证明 见测试用例 SynchornizeTest
     * @param info
     */
    public synchronized void  syncCodeBlock(Info info) {
        System.out.println(info.getValue());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
