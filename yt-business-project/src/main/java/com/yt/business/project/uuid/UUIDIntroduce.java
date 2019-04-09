package com.yt.business.project.uuid;

/**
 * Created by yantong on 2019/4/9.
 *
 * 必须：
 *  唯一性：确保生成的ID是全网唯一的。
 *  高可用性：确保任何时候都能正确的生成ID。
 *
 * 非必须：
 *  有序递增性：确保生成的ID是对于某个用户或者业务是按一定的数字有序递增的。//非必须
 *  带时间：ID里面包含时间，一眼扫过去就知道哪天的交易。
 *
 * impl：                        唯一  高可用       递增  连续 带时间  过长   有性能瓶颈
 *  机器码 + 时间戳 + Random     是    是                      是      是     否
 *  数据库自增（步长不一致）     是    是                      否      否     是
 *  数据库记录最大值（批量ID）   是    否/单点故障             否      否     缓解
 *  Redis生成ID（步长不一致）    是    ？？？                  否      否     否           比较适合使用 Redis 来生成每天从0开始的流水号
 *  Snowflake（Zookeeper）       0.9   是           是    是   否      否     否
 *  UidGenerator
 *  Leaf
 *
 *  Snowflake：[Twitter] TODO demo https://juejin.im/post/5b3a23746fb9a024e15cad79
 *      byte:从左到右
 *      1位：0 ，1 正负
 *      41位：距离机器启动的时间戳：69年
 *      10位：数据标记位[5]+机器标记位[5]:集群最大2<<10=1024台
 *      12位：计数：支持每个节点每毫秒（同一台机器，同一时刻）最多生成 1 << 12 = 4096个ID 加起来刚好64位，为一个Long型
 *      缺点：依赖机器时钟（可变）：TODO 尝试解决：https://juejin.im/post/5bb0217ef265da0ac2567b42
 *  UidGenerator：[Baidu] based on Snowflake
 *  Leaf：[美团] TODO https://link.juejin.im/?target=https%3A%2F%2Ftech.meituan.com%2FMT_Leaf.html
 */
public interface UUIDIntroduce {
}
