package com.yt.net.time.impl.server;

import com.alibaba.fastjson.util.IOUtils;
import com.yt.net.time.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yantong on 2019/2/18.
 *
 * Socket不属于OSI七层网络模型，是对于TCP的一个抽象，便于程序中方便的使用TCP协议
 * 这是一个简单的 socket 长连接demo
 * socket对象会 一直阻塞在 accept操作上
 */
public class SocketLongConnectionServer implements Server {

    private Logger logger = LoggerFactory.getLogger(SocketLongConnectionServer.class);

    private int port;

    public SocketLongConnectionServer(int port) {
        this.port = port;
    }

    @Override
    public void start() {
        ServerSocket server = null;
        try {
            // 创建好监听器
            server = new ServerSocket(port);
            logger.info("服务器启动==========");
            System.out.println("服务器启动==========");
            while (true) {
                Socket sc = server.accept();// 进入阻塞状态，直到接收到发送发消息，返回给我们一个Socket
                // 开启线程处理socket
                handleSocket(sc);
            }
        } catch (IOException e) {
            logger.error("Server io error", e);
        } finally {
            IOUtils.close(server);
        }
    }

    private void handleSocket(Socket sc) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            String msg = br.readLine();
            System.out.println(msg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("socket io异常", e);
        } finally{
            IOUtils.close(sc);
        }
    }
}
