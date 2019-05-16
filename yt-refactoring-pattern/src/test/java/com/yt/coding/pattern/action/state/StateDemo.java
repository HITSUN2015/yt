package com.yt.coding.pattern.action.state;

import java.util.concurrent.TimeUnit;

/**
 * @author SUN
 * @create 2019-05-13 15:24
 * @desc
 */
public class StateDemo {


    private enum InnerStatus {
        OPENED,
        CLOSED
    }

    private InnerStatus state;

    public void action() {
        if (state == InnerStatus.OPENED) {
            System.out.println("fsdf");
        } else if (state == InnerStatus.CLOSED) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
