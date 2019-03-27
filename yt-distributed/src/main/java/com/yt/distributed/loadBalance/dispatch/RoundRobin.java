package com.yt.distributed.loadBalance.dispatch;

/**
 * Created by yantong on 2019/3/27.
 *
 * 轮询
 *
 * eg:DNS : 由于 某个 ip的服务 宕机后 ，dns 服务器中仍缓存有该ip
 *          造成部分用户(或某次请求 ？TODO ) 服务不可用
 *          所以 DNS 不能作为独立的 负载均衡策略
 */
public class RoundRobin {
}
