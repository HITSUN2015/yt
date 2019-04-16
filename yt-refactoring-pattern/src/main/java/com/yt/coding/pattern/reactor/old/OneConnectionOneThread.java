package com.yt.coding.pattern.reactor.old;

import com.yt.coding.pattern.reactor.MultiThread;
import com.yt.coding.pattern.reactor.NetHandler;
import com.yt.coding.pattern.reactor.AbstractNetHandler;

import java.util.concurrent.*;

/**
 * Created by yantong on 2019/3/6.
 *
 * 缺点：高并发下，耗费线程资源，每一个请求需要一个线程（如果未用线程池的话）
 *       如果用线程池的话，并发度也是有限的
 */
public class OneConnectionOneThread extends AbstractNetHandler implements NetHandler,MultiThread {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 100000,
            10L, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    @Override
    public String handle() {
//        Thread t = new Thread(()-> work()); TODO 这样执行的线程 里面线程有未执行完毕的情况
        executor.submit(() -> work());

        executor.getActiveCount();
        return null;
    }

    @Override
    public boolean isAllWorkDone() {
        if (executor.getActiveCount() > 0) {
            return false;
        }
        return true;
    }
}
