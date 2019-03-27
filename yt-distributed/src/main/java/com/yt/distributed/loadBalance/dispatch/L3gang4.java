package com.yt.distributed.loadBalance.dispatch;

/**
 * Created by yantong on 2019/3/27.
 *
 * 通过OSI模型中 第3（传输tcp、udp）、4(网络ip)层实现
 *
 * 不是很稳定：当一个服务实例失效或用户的IP发生变化的时候，用户与服务实例之间的对应关系就将发生改变。此时用户原有的会话数据在新的服务实例上并不存在，进而导致一系列问题
 *
 * 最根本原因就是用户与服务实例之间的关联关系是通过某些外部环境创建的，而并非由用户/服务实例本身来管理。因此它不能抵御外部环境变化的冲击
 *
 * 解决办法：Cookie：{@link L7}
 */
public class L3gang4 {
}
