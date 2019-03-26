package com.yt.spi;

import java.util.ServiceLoader;

/**
 * Created by yantong on 2019/3/2.
 *
 * 介绍：SPI的全名为Service Provider Interface.大多数开发人员可能不熟悉，因为这个是针对厂商或者插件的。
 *      为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制。
 *      Java SPI就是提供这样的一个机制：为某个接口寻×××实现的机制。
 *
 * 条件1：目录：classPath ？未测试 或 resrouce/META-INF/services/
 *      2:文件：packagePath.className
 *      3.内容：实现类：packagePath.className
 *
 * 样例：Mysql-connector-java:5.1.44 目录下有java.sql.Driver 文件
 *
 * 缺点（随意抄的：https://www.jianshu.com/p/7daa38fc9711）：
 *     虽然ServiceLoader也算是使用的延迟加载，但是基本只能通过遍历全部获取，也就是接口的实现类全部加载并实例化一遍。如果你并不想用某些实现类，它也被加载并实例化了，这就造成了浪费。
 *     获取某个实现类的方式不够灵活，只能通过Iterator形式获取，不能根据某个参数来获取对应的实现类。
 *
 * {@link ServiceLoader} 的
 * private static final String PREFIX = "META-INF/services/";
 *
 */
public class RunTestInterfaceBySPI {

    public void runTestInterfaceBySPI() {
        ServiceLoader<TestInterface> loader = ServiceLoader.load(TestInterface.class);
        System.out.println(loader);

        for (TestInterface Cmand : loader) {
            System.out.println(Cmand.test());
        }
    }
}
