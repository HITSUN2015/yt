package com.yt.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by yantong on 2019/2/22.
 */
@Service
public class RedisDemo {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    private void show() {

    }
}
