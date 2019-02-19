package com.yt.net.time;

/**
 * Created by yantong on 2019/2/18.
 *
 * 优点：不用重复握手
 * 缺点：占用资源，并发量小 （NIO 是不是能有效的缓解这个问题）
 * 应用：MQ、数据库、JPush、直播、IM、游戏、弹幕、app想要实时的接收某些消息
 * 应用自攥特点：client数量可控、交互较为频繁或数据量大
 *
 * 参考：http://www.doc88.com/p-9159306237959.html
 */
public interface LongConnection {
}
