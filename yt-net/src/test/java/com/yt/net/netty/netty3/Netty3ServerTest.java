package com.yt.net.netty.netty3;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yantong on 2019/3/8.
 */
@Test
public class Netty3ServerTest {

    //与main方法不同，这个test方法不会驻留
    @Test
    public void testServer() {
        Netty3Server.startup();
        try {
            TimeUnit.MINUTES.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
