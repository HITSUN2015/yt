package com.yt.jdk.process.communicate;

import com.yt.jdk.process.communicate.mq.IPCMQIntroduce;
import com.yt.jdk.process.communicate.socket.IPCSocketDemo;
import com.yt.jdk.process.communicate.socket.netty.IPCNettyDemo;

/**
 * Created by yantong on 2019/3/29.
 *
 * IPC:Inter-Process Communication
 *
 * 参见 https://stackoverflow.com/questions/10942427/how-to-have-2-jvms-talk-to-one-another
 *
 * 这里可以确定的是，基于网络的通信技术，一定能实现单机的进程间通信：基于IP、port
 * 1.socket
 *      {@link IPCSocketDemo}
 *      ->netty {@link IPCNettyDemo}
 * 2.RMI
 *      {@link com.yt.jdk.process.communicate.rmi.RMIIntroduce}
 * 3.Fully-fledged Message Passing Architectures
 *      {@link IPCMQIntroduce}
 * 4.JMX
 *      {@link com.yt.jdk.process.communicate.jmx.JMXIntroduce}
 * 5.Share Memory
 *      {@link com.yt.jdk.process.communicate.shareMemory.IPCShareMemoryIntroduce}
 * 6.
 *
 */
public class IPCIntroduce {

}
