package com.yt.spring.bean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yantong on 2019/1/25.
 */
@Configuration
public class ThreadPoolConfig extends WebMvcConfigurerAdapter {

    @Bean(autowire = Autowire.BY_NAME)
    public ThreadPoolTaskExecutor testExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(20);
        pool.setQueueCapacity(200);
        pool.setMaxPoolSize(50);
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        pool.setKeepAliveSeconds(10);
        pool.setThreadNamePrefix("test-");
        return pool;
    }

}
