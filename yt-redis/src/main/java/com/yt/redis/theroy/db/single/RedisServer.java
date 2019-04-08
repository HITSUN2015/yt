package com.yt.redis.theroy.db.single;

/**
 * Created by yantong on 2019/4/8.
 */
public class RedisServer {

    private RedisDb[] redisDb;  //数据库数组对象 客户端的默认目标是 redisDb[0]
    private int dbNum;          //数据库个数 默认16 配置：TODO

}
