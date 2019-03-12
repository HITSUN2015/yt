package com.yt.net.netty3.demo;/**
 * Created by SUN on 19/3/4.
 */

import org.apache.logging.log4j.core.util.StringEncoder;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.springframework.core.codec.StringDecoder;

import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutorService;rs
import java.util.concurrent.Executors;

/**
 * @author SUN
 * @create 2019-03-04 下午10:38
 * @desc netty的服务端demo
 */
public class Netty3Server {

    public void setup() {

        //服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        //boss线程监听端口，worker线程负责数据读写  他们里面都会负责一个selector。
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //设置niosocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        //设置管道的工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {

                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("helloHandler", new HelloHandler());
                return pipeline;
            }
        });

        bootstrap.bind(new InetSocketAddress(10101));

        System.out.println("start!!!");
    }
}
