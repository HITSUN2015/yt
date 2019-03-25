package com.yt.datastructure.datastructure.net.time.impl.server;

import com.yt.datastructure.datastructure.net.time.Client;
import com.yt.datastructure.datastructure.net.time.Server;
import com.yt.datastructure.datastructure.net.time.impl.client.SocketLongConnectionClient;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/18.
 */
@Test
public class SocketLongConnectionServerTest {

    @Test
    public void stressTest() {
        String ip = "127.0.0.1";
        int port = 8080;

        Thread serverThread = new Thread(() -> {
            Server server = new SocketLongConnectionServer(port);
            server.start();
        });

        serverThread.start();

        for(int i = 0; i < 20 ; i++) {
            Thread clientThread = new Thread(() -> {
                Client client = new SocketLongConnectionClient(ip, port);
                client.send();
            });
            clientThread.start();
        }

        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
