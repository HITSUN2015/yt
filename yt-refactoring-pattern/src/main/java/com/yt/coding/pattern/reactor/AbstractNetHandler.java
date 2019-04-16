package com.yt.coding.pattern.reactor;

import java.util.Random;

/**
 * Created by yantong on 2019/3/6.
 */
public abstract class AbstractNetHandler implements NetHandler{

    private static final Integer MAX_COUNT = 10000000;

    public int work() {
        int result = 0;
        Random random = new Random();
        for(int i = 0; i < MAX_COUNT; i++ ) {
            result += random.nextInt();
        }
        System.out.println("end");
        return result;
    }

    @Override
    public int getCalculateCounter() {
        return MAX_COUNT;
    }
}
