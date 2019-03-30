package com.yt.jdk.process.communicate.rmi;

/**
 * Created by yantong on 2019/3/30.
 *
 * Java Remote Method Invocation
 * 比RPC(Remote Procedure Call)更进一步
 *
 * 目标：
 *      是允许运行在一个Java虚拟机的对象调用运行在另一个Java虚拟机上的对象的方法
 *      这两个虚拟机可以是运行在相同计算机上的不同进程中，也可以是运行在网络上的不同计算机中
 *      RMI全部的宗旨就是尽可能简化远程接口对象的使用
 *
 * 缺点：
 *      JAVA communicate with JAVA
 *
 * 组成：
 *      远程服务的接口定义 TODO link
 *      远程服务接口的具体实现
 *      桩（Stub）【客户端】和框架（Skeleton）【服务端】文件
 *      一个运行远程服务的服务器
 *      一个RMI命名服务，它允许客户端去发现这个远程服务
 *      类文件的提供者（一个HTTP或者FTP服务器）
 *      一个需要这个远程服务的客户端程序
 * 通常 接口 会单独打包 供 客户端依赖
 *
 * 架包：
 *      Spring todo demo
 *      EJB // TODO: 2019/3/30 demo
 */
public interface RMIIntroduce {
}
