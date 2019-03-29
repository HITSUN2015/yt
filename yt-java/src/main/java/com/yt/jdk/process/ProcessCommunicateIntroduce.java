package com.yt.jdk.process;

/**
 * Created by yantong on 2019/3/29.
 *
 * 进程间通信，跨机器的 参见 yt-net 模块
 *
 * 这里讨论下，可以实现，单机进程间通信的技术
 * 参见 https://stackoverflow.com/questions/10942427/how-to-have-2-jvms-talk-to-one-another
 *
 * 这里可以确定的是，基于网络的通信技术，一定能实现单机的进程间通信：基于IP、port
 * 1.{@link java.net.Socket}
 *      ->netty
 * 2.JMI Java remote method invocation
 *  https://www.cnblogs.com/xt0810/p/3640167.html
 *
 */
public class ProcessCommunicateIntroduce {

    /*
    Multiple options for IPC:

Socket-Based (Bare-Bones) Networking
not necessarily hard, but:
might be verbose for not much,
might offer more surface for bugs, as you write more code.
you could rely on existing frameworks, like Netty
RMI
Technically, that's also network communication, but that's transparent for you.
Fully-fledged Message Passing Architectures
usually built on either RMI or network communications as well, but with support for complicated conversations and workflows
might be too heavy-weight for something simple
frameworks like ActiveMQ or JBoss Messaging
Java Management Extensions (JMX)
more meant for JVM management and monitoring, but could help to implement what you want if you mostly want to have one process query another for data, or send it some request for an action, if they aren't too complex
also works over RMI (amongst other possible protocols)
not so simple to wrap your head around at first, but actually rather simple to use
File-sharing / File-locking
that's what you're doing right now
it's doable, but comes with a lot of problems to handle
Signals
You can simply send signals to your other project
However, it's fairly limited and requires you to implement a translation layer (it is doable, though, but a rather crazy idea to toy with than anything serious.
Without more details, a bare-bone network-based IPC approach seems the best, as it's the:

most extensible (in terms of adding new features and workflows to your
most lightweight (in terms of memory footprint for your app)
most simple (in terms of design)
most educative (in terms of learning how to implement IPC). (as you mentioned "socket is hard" in a comment, and it really is not and should be something you work on)
That being said, based on your example (simply requesting the other process to do an action), JMX could also be good enough for you.
     */
}
