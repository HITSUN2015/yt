package com.yt.db.mysql;

/**
 * Created by yantong on 2019/4/4.
 */
public class PiecesKnowdge {

    //WAL（Write-Ahead Logging）：解决内存和硬盘的随机读写速度差异问题
    //将随机写 改成 顺序写提升效率
    //关于 缓存未刷新到 内存的时间 数据不一致问题 TODO

    //ACID，的保证：A：undo D:redo

    //Double write 一页大小是16k 但是磁盘是512k，为什么会有写一半写不下的情况 TODO
    //这种方法已废弃，由硬盘解决，硬盘支持32k的块写入

    //mysql innodb 重要参数：innodb_flush_log_at_trx_commit (0,1,2)
    //                       stbc_binlog(0,1,2)
    //我们的实际是：(2,0)
    //缓存脏数据的生成条件：4个TODO
    //redo的执行条件：innodb_flush_log_at_trx_commit
    //                buf满了
    //类似交易系统，要求较高（1,1）会有2PC：prepare commit。个人感觉类似单通，2 times handshake

    //主复制到从 支持事务：binlog插件，是全局配置
    //（mongo支持根据特定语句做这个）

    //从库load的一致性 TODO
}
