package com.yt.jdk.process.communicate;

import com.yt.jdk.process.communicate.mq.ProcessCommunicateMQIntroduce;

/**
 * Created by yantong on 2019/3/29.
 *
 * IPC:Inter-Process Communication
 *
 * 参见 https://stackoverflow.com/questions/10942427/how-to-have-2-jvms-talk-to-one-another
 *
 * 这里可以确定的是，基于网络的通信技术，一定能实现单机的进程间通信：基于IP、port
 * 1.socket
 *      {@link com.yt.jdk.process.communicate.socket.JDKProcessCommunicateSocketDemo}
 *      ->netty {@link com.yt.jdk.process.communicate.socket.netty.JDKProcessCommunicateNettyDemo}
 * 2.RMI
 *      {@link com.yt.jdk.process.communicate.rmi.RMIIntroduce}
 * 3.Fully-fledged Message Passing Architectures
 *      {@link ProcessCommunicateMQIntroduce}
 * 4.JMX
 *      {@link com.yt.jdk.process.communicate.jmx.JMXIntroduce}
 * 5.
 *
 */
public class IPCIntroduce {

    public static void main(String[] args) {
    }
}
