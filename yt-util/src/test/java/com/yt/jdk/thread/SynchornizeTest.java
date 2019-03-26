package com.yt.jdk.thread;

import com.yt.jdk.thread.baseModel.Info;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/15.
 */
@Test
public class SynchornizeTest {

    @Test
    public void test1() {
        Info info1 = new Info("info1");
        Info info2 = new Info("info2");
        Synchronize synchronize = new Synchronize();
        Thread thread1 = new Thread(() -> {
            synchronize.syncCodeBlock(info1);
        });
        Thread thread2 = new Thread(() -> {
            synchronize.syncCodeBlock(info2);
        });
        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Info info1 = new Info("info1");
        Synchronize synchronize1 = new Synchronize();
        Synchronize synchronize2 = new Synchronize();
        Thread thread1 = new Thread(() -> {
            synchronize1.syncCodeBlock(info1);
        });
        Thread thread2 = new Thread(() -> {
            synchronize2.syncCodeBlock(info1);
        });
        thread1.start();
        thread2.start();
        try {
            thread2.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
