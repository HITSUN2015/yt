package com.yt.jdk.thread.pipe.modal;

import java.io.PipedInputStream;

/**
 * Created by yantong on 2019/2/16.
 */
public class PipReader {

    private String name;
    private PipedInputStream pipIn;

    public PipReader(String name, PipedInputStream pipIn) {
        this.name = name;
        this.pipIn = pipIn;
    }

    public void read() {
        try {
            // TODO: 2019/2/16 这里 如果速度过快 传入的过多
            byte[] bytes = new byte [1024];
            int len;
            while ((len = pipIn.read(bytes)) != -1) {
                System.out.println(name);
                System.out.println(new String(bytes,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
