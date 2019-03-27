package com.yt.distributed.loadBalance.send;

/**
 * Created by yantong on 2019/3/27.
 *
 * 负载均衡服务器以及各个服务实例必须在同一个网段上并使用同一个IP
 *
 * 负载均衡服务器 把 请求 直接 给服务实例
 *
 * 负载均衡服务器和各个服务实例都不需要对IP（Internet Protocol）层数据进行任何更改就可以对其进行转发
 *
 * 使用这种转发方式的负载均衡服务器的吞吐量非常高
 *
 * 这种组织方式也要求集群的搭建人员对TCP/IP等协议拥有足够多的理解
 */
public interface DirectRouting {

}
