package com.yt.net.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by yantong on 2019/2/16.
 */
public class TCPSocketClient {

    public static void main(String[] args) {

        // 连接服务器
        try {
            Socket socket = new Socket("localhost",9000);
            System.out.println("Client连接Server成功");
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            PrintStream ps = new PrintStream(out);
            ps.println("Client:hello");
            BufferedReader br = new BufferedReader(new InputStreamReader(in)); // 字节转字符
            String info = br.readLine();
            System.out.println(info);
            out.close();
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
