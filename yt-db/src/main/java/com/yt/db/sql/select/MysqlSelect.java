package com.yt.db.sql.select;

/**
 * Created by yantong on 2019/3/22.
 */
public class MysqlSelect {

    //时间
    /**
     * 统计七天内新建
     * SELECT count(*) from alarm_event WHERE create_time >= date_sub(now(), INTERVAL 7 day);
     * 或 直接明确时间
     * SELECT count(*) from alarm_event WHERE create_time >= '2017-01-01 00:00:00');
     *
     */


}
