package com.yt.distributed.loadBalance;

/**
 * Created by yantong on 2019/3/27.
 *
 * http://www.360doc.com/content/18/0731/10/40769523_774607019.shtml
 *
 * 说负载均衡，也可以说 调度算法
 *
 * 需要解决的问题：
 * 1.知道哪个ip还活着
 *     1）负载均衡服务主动查询 节点机器
 *        i.  ping：缺点：服务挂了，机器还活着
 *        ii. tcp： 缺点：服务挂起，http业务无法处理
 *        iii.customer 脚本 可能会要求服务返回具体数据等
 * 2.根据算法 分发 请求
 */
public interface Inroduce {
}
