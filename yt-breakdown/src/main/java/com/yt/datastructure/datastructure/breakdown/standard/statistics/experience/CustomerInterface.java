package com.yt.datastructure.datastructure.breakdown.standard.statistics.experience;

/**
 * Created by yantong on 2019/3/18.
 *
 * reason
 * 服务提供方 customerMethod 接口异常
 * （根因是这套接口是单独为**公司定制的，有独立的入口域名和服务，原因是SSL证书过期，导致服务不可用）
 * **公司采用百度 服务提供方 SDK调用该接口失败。
 *
 * action
 * 对服务提供方接口 也要有监控 或者 熔断处理
 */
public class CustomerInterface {
}
