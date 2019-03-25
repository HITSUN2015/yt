package com.yt.datastructure.datastructure.util.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Created by yantong on 2019/1/25.
 */
public class RetryRunnable implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RetryRunnable.class);

    private Callable<Integer>  target;//// TODO: 2019/1/25找到那个 status类 搬过来
    private int defaultMaxRetryTime = 3;
    private int curRunTime = 1;

    public RetryRunnable(Callable target) {
        this.target = target;
    }

    public RetryRunnable(Callable target, int defaultMaxRetryTime) {
        this.target = target;
        this.defaultMaxRetryTime = defaultMaxRetryTime;
    }

    @Override
    public void run() {
        if (null == target) return;
        for(; curRunTime <= defaultMaxRetryTime ; curRunTime++) {
            try {
                int result = target.call();
                if (result == 1) {
                    break;
                }
            } catch (Exception e) {
                logger.error("run time error: {}", curRunTime, e);
            }
        }
    }
}
