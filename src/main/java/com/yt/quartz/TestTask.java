package com.yt.quartz;

import org.springframework.stereotype.Service;

/**
 * Created by yantong on 2018/11/22.
 */
@Service("testTask")
public class TestTask {

    public void doTask(){
        System.out.println(1);
    }
}
