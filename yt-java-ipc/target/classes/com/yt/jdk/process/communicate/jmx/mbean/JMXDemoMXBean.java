package com.yt.jdk.process.communicate.jmx.mbean;

import java.io.Serializable;

/**
 * Created by yantong on 2019/3/30.
 *
 * 这个名字 我原命名为：JMXDemoMBean
 * 会抛出：does not implement DynamicMBean, and neither follows the Standard MBean conventions (javax.management.NotCompliantMBeanException
 * 应该是一个取巧的方法吧，在名字加了 M X Bean 以去掉检查 参见：https://stackoverflow.com/questions/25308744/creating-mbean-in-java
 * 总之，感觉这个方法，比较累
 */
public interface JMXDemoMXBean extends Serializable {

    String getTestString();
}
