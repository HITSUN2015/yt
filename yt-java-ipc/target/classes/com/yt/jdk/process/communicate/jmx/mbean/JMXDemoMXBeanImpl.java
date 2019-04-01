package com.yt.jdk.process.communicate.jmx.mbean;


/**
 * Created by yantong on 2019/3/30.
 */
public class JMXDemoMXBeanImpl implements JMXDemoMXBean {

    @Override
    public synchronized String getTestString() {
        return "TEST_STRING";
    }
}
