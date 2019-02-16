package com.yt.net.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yantong on 2019/2/16.
 */
public class TCPSocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server已经启动，等待Client链接。。。");
            Socket socket = ss.accept(); // 等待客户端连接，该方法会阻塞
            InputStream input = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input)); // 字节转字符
            String info = br.readLine();
            System.out.println(info);
            OutputStream output = socket.getOutputStream();
            PrintStream ps = new PrintStream(output);
            ps.println("Server:hello");
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
