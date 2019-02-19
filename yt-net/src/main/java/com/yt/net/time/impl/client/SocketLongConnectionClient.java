package com.yt.net.time.impl.client;

import com.yt.net.time.Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by yantong on 2019/2/18.
 */
public class SocketLongConnectionClient implements Client {

    private String ip;
    private int port;

    public SocketLongConnectionClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void send() {
        String msg = "你好，我是客户端！";
        // 发送方Socket操作
        Socket socket = null;
        try {
            socket = new Socket(ip, port);// 开启Socket链接
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);
            bw.flush();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();// 关闭Socket
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
