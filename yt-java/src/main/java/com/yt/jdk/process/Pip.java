package com.yt.jdk.process;

import com.yt.jdk.process.modal.PipReader;
import com.yt.jdk.thread.Join;
import com.yt.jdk.thread.Message;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by yantong on 2019/2/16.
 * 这个类我查了一小下
 * 并没有查到 在哪个开源项目中的应用
 * 如下 抄自 https://yq.aliyun.com/articles/624273/
 */
public class Pip implements Message {
    //管道输出流
    private static PipedOutputStream outputStream = new PipedOutputStream();
    //管道输入流
    private static PipedInputStream inputStream1 = new PipedInputStream();
    private static PipedInputStream inputStream2 = new PipedInputStream();

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

        //连接管道
        inputStream1.connect(outputStream);
        //一个管道 只有一个进口和出口 否则抛出 java.io.IOException: Already connected
//        inputStream2.connect(outputStream);

        //启动线程
        new Thread(out).start();
        new Thread(() ->{
            PipReader pipReader = new PipReader("thread-1", inputStream1);
            pipReader.read();
        }).start();
//        new Thread(() ->{
//            PipReader pipReader = new PipReader("thread-1", inputStream2);
//            pipReader.read();
//        }).start();
    }

}
