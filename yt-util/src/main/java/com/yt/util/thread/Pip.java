package com.yt.util.thread;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by yantong on 2019/2/16.
 * 这个类我查了一小下
 * 并没有查到 在哪个开源项目中的应用
 * 如下 抄自 https://yq.aliyun.com/articles/624273/
 */
public class Pip implements Message{
    //管道输出流
    private static PipedOutputStream outputStream = new PipedOutputStream();
    //管道输入流
    private static PipedInputStream inputStream = new PipedInputStream();

    /**
     * 这个方法里 while循环时，主线程并没有停
     * 而{@link Join} thread 内部 sleep main线程会停止
     * 应该和sleep交出锁有关系 TODO
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //输出线程
        Runnable out = ()-> {
            try {
                while(true) {
                    Thread.sleep(1000);
                    outputStream.write("pipe".getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        //输入线程
        Runnable in = ()-> {
            try {
                byte[] bytes = new byte [1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes,0,len));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        //连接管道
        inputStream.connect(outputStream);
        //启动线程
        new Thread(out).start();
        new Thread(in).start();
    }

}
