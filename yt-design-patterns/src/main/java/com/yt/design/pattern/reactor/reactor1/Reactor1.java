package com.yt.design.pattern.reactor.reactor1;

/**
 * Created by yantong on 2019/3/6.
 */
public class Reactor1 implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

            }
        } catch (Exception ex) { /* ... */ }
    }

    void dispatch(Runnable r) {
        if (r != null)
            r.run();
    }


}
