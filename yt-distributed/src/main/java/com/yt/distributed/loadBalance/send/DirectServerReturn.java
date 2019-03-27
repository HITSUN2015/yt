package com.yt.distributed.loadBalance.send;

/**
 * Created by yantong on 2019/3/27.
 *
 * 由服务器 直接 返回给用户
 *
 * 这里说明的是 {@link DirectRouting},{@link Tunnelling} 均可实现 服务实例 直接返回给用户
 */
public interface DirectServerReturn extends DirectRouting, Tunnelling {
}
