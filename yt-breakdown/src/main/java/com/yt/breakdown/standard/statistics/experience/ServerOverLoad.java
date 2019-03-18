package com.yt.breakdown.standard.statistics.experience;

/**
 * Created by yantong on 2019/3/18.
 *
 * 1.国内海外 用户差距较大，不好用国内服务容量 规划 海外
 * server A relay on B
 * 2.实时性要求不高：本身可能用队列处理，本次根因是：B服务处理不过来，导致队列超限
 * action
 * 本例有个特点，relay on B是查询B的信息，然后向C设置（用户不急于关注C的状态，并且值有两个a(90%) b(10%)）
 *    所以每次查B前，对C设置一个a,查询出不是a的情况，再对C设置B
 *
 * 个人认为 无法解决，查询慢的问题
 */
public class ServerOverLoad {
}
