package com.yt.net.netty.netty3;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yantong on 2019/3/7.
 */
public class Netty3Server {

    private final static Logger LOGGER = LoggerFactory.getLogger(Netty3Server.class);

    private final static int SERVER_PORT = 10010;

    public static void startup() {
        ServerBootstrap bootstrap = new ServerBootstrap();

        //设置线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //设置nioSocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        //设置管道
        bootstrap.setPipelineFactory(()->{
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("decoder", new StringDecoder());
            pipeline.addLast("encoder", new StringEncoder());
            pipeline.addLast("helloHandler", new HelloHandler());
            return pipeline;
        });

        //监听端口
        bootstrap.bind(new InetSocketAddress(SERVER_PORT));

        LOGGER.info("Netty3Server started,port:{}", SERVER_PORT);
    }
}