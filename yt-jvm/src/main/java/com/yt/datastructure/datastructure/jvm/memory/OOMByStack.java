package com.yt.datastructure.datastructure.jvm.memory;/**
 * Created by SUN on 18/3/14.
 */

/**
 * @author SUN
 * @create 2018-03-14 下午10:52
 * @desc OOM 由申请栈空间不足而引起 的样例
 */
public class OOMByStack {
    /**
     * -Xss5M -Xmx1024m 这段代码吧,听的歌瞬间就卡了,机器操作也卡了...我就虚了...
     *  文中说,如果是windows建议执行前保存程序...windows是用内核空间给栈分配空间
     *  我确实没测出是否存储进程 的 memory上线,不想这么搞机器...
     * @param args
     */
    public static void main(String[] args) {
        while(true){
            new Thread(){
                @Override
                public void run() {
                    while(true);
                }
            }.start();
        }
    }
}
