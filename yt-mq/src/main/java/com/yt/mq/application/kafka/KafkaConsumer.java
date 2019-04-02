package com.yt.mq.application.kafka;

import kafka.javaapi.consumer.ConsumerConnector;

/**
 * Created by yantong on 2019/1/11.
 *
 * 相关资料：http://www.cnblogs.com/liuming1992/p/6432506.html
 *
 * // TODO: 2019/3/30
 */
public class KafkaConsumer {

    private ConsumerConnector consumerConnector;

    public void consume() {
        consumerConnector.createMessageStreams(null );
    }
}
