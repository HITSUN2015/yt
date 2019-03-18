package com.yt.breakdown.standard.statistics.experience;

/**
 * Created by yantong on 2019/3/18.
 *
 * （报警不够及时，监控项丢失）
 *
 * 1.接口平均耗时分析：上涨了-》1）网络 2）数据库
 * 2.性能分析：服务器TPS 1000-1100TPS
 *             数据库TPS 4000-6000TPS
 * 3.源码分析：线程数 4：太少
 * action：线程数：20
 *         增加一半机器
 *
 * 后续又故障：
 *    优化数据库主备复制性能，解决数据库主备不同步的问题 该参数会动态增加数据库0-1ms的操作时间
 *    决策扩容消费节点数等于partition数
 *    消费积压的速度不够快，临时扩容6个device_basic节点
 *
 *
 *
 */
public class KafkaOverStock {
}
