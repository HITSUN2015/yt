package com.yt.db.sql.select;

/**
 * Created by yantong on 2019/3/22.
 *
 * TODO 以下sql 偏 实现 并未校准过效率
 */
public class MysqlSelect {


    /**
     * TIME ：
     * date_sub(now(), INTERVAL 7 day)
     * HOUR(e.create_time)
     *
     *
     * 统计七天内新建
     * SELECT count(*) from alarm_event WHERE create_time >= date_sub(now(), INTERVAL 7 day);
     * 或 直接明确时间
     * SELECT count(*) from alarm_event WHERE create_time >= '2017-01-01 00:00:00');
     *
     * 显示 每天的统计量
     * select d.t, count(*) from (select HOUR(e.create_time) as t from alarm_event e where create_time >= date_sub(now(), INTERVAL 7 day)) as d GROUP BY d.t;
     *
     */


}
