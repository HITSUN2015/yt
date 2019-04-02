package com.yt.mq.application.kafka;

import kafka.consumer.ConsumerConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yantong on 2019/1/11.
 * 这个类 按照 属性名称的 点 换成 驼峰
 */
public class KafkaConfig {

    public static ConsumerConfig generateConsumerConfig(String groupId, String zookeeperConnect) {
        if (null == groupId || null == zookeeperConnect || groupId.length() == 0 || zookeeperConnect.length() == 0) {
            throw new RuntimeException("初始化 kafka配置时，未传入 groupId 或 zookeeperConnect");
        }

        Properties pro = new Properties();
        pro.setProperty("group.id", groupId);
        pro.setProperty("zookeeper.connect", zookeeperConnect);
        DEFAULT_CONFIGS.forEach((x,y)-> pro.setProperty(x, y));
        return new ConsumerConfig(pro);
    }

    public static ConsumerConfig generateConsumerConfig(Map<String, String> configMap) {
        if (null == configMap) {
            throw new RuntimeException("初始化 kafka配置时，未传入配置信息 configMap");
        }
        if (!configMap.containsKey("group.id") || !configMap.containsKey("zookeeper.connect")) {
            throw new RuntimeException("初始化 kafka配置时，未传入配置信息 group.id 或 zookeeper.connect");
        }
        if (null == configMap.get("group.id") || configMap.get("group.id").length() == 0
                || null == configMap.get("zookeeper.connect") || configMap.get("zookeeper.connect").length() == 0) {
            throw new RuntimeException("初始化 kafka配置时，传入配置信息 group.id 或 zookeeper.connect 为空");
        }

        Properties pro = new Properties();
        DEFAULT_CONFIGS.forEach((x,y)-> pro.setProperty(x, y));
        configMap.forEach((x,y)-> pro.setProperty(x, y));//TODO think 这里没有new新对象
        return new ConsumerConfig(pro);
    }


    private final static Map<String, String> DEFAULT_CONFIGS = new HashMap<String, String>(){{
        /**
         * The socket timeout for network requests. The actual timeout set will be max.fetch.wait +
         * socket.timeout.ms.
         */
        put("socket.timeout.ms", "30000");
        /**
         * The socket receive buffer for network requests
         */
        put("socket.receive.buffer.bytes", 1024 * 64 + "");
        /**
         * this helps control the memory used by the consumer. The fetch request size must be at
         * least as large as the maximum message size the server allows or else it is possible for
         * the producer to send messages larger than the consumer can fetch.
         */
        put("fetch.message.max.bytes", 1024 * 1024 + "");
        /**
         * by the consumer. This committed offset will be used when the process fails as the
         * position from which the new consumer will begin.
         */
        put("auto.commit.enable", "true");
        /**
         * The frequency in ms that the consumer offsets are committed to zookeeper.
         */
        put("auto.commit.interval.ms", "5000");
        /**
         * Max number of message chunks buffered for consumption. Each chunk can be up to
         * fetch.message.max.bytes.
         */
        put("queued.max.message.chunks", "10");
        /**
         * Zookeeper session timeout. If the consumer fails to heartbeat to zookeeper for this
         * period of time it is considered dead and a rebalance will occur.
         */
        put("zookeeper.session.timeout.ms", "30000");
        /**
         * How far a ZK follower can be behind a ZK leader
         */
        put("zookeeper.sync.time.ms", "2000");
        /**
         * rebalanceMaxRetries
         */
        put("rebalance.max.retries", "1000000");
        /**
         * backoff time between retries during rebalance
         */
        put("rebalance.backoff.ms", "5000");
    }};
}
