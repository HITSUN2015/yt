package com.yt.distributed.loadBalance.send;

/**
 * Created by yantong on 2019/3/27.
 *
 * VIP:Virtual IP
 * RIP:Real IP (服务实例IP)
 * UIP:user IP
 * 时序：
 *                       source      target
 * 用户request           UIP         VIP
 * loadBalancer request  VIP         RIP
 * 服务实例 response     RIP         VIP
 * loadBalancer response VIP         UIP
 *
 * 负载均衡服务器会维持一系列会话，以记录每个经由负载均衡服务器的正在处理的各个请求的相关信息
 *
 * 维护的时间长：会话过多
 * 维护时间短：ACK Storm TODO
 *
 */
public interface IPAddressTranslation {
}
