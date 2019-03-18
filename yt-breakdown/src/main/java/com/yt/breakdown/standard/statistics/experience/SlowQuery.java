package com.yt.breakdown.standard.statistics.experience;

/**
 * Created by yantong on 2019/3/18.
 *
 * 1.紧急解决：分析慢查 top5 kill 慢查
 *
 * 主要是 2B 的 调用了 2C的接口
 *
 * 或者 2C的用户 量变 成 B的用户
 *
 * 1.临时方案：查询出所有这类用户，做降级
 * 2.经验总结：即使是C用户，最好也考虑数据量大的情况，或者 提前对C用户做限制
 */
public class SlowQuery {
}
