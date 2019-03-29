package com.yt.linux.command;

/**
 * Created by yantong on 2019/3/29.
 *
 * 说比较过时了，新的可能用ss名 TODO
 */
public class NetStat {

    /**
     * -t
     *  tcp协议
     * -u
     *  udp协议
     * -a
     *  all
     * -n
     *  TODO
     * -p
     *  需要root权限 显示进程id
     *
     * 常用：
     *
     * 查看某个端口 被什么进程占用
     *
     * 查看 某端口连接数
     * netstat -nat | grep -i "8080" -c
     *
     * 统计已连接上的，状态为“established
     * netstat -anp | grep ESTABLISHED -c
     *
     * 统计
     * # netstat -n | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'
        TIME_WAIT 8947 等待足够的时间以确保远程TCP接收到连接中断请求的确认
        FIN_WAIT1 15 等待远程TCP连接中断请求，或先前的连接中断请求的确认
        FIN_WAIT2 1 从远程TCP等待连接中断请求
        ESTABLISHED 55 代表一个打开的连接
        SYN_RECV 21 再收到和发送一个连接请求后等待对方对连接请求的确认
        CLOSING 2 没有任何连接状态
        LAST_ACK 4 等待原来的发向远程TCP的连接中断请求的确认
     */
}
