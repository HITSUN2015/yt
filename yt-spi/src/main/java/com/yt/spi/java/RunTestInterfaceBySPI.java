package com.yt.spi.java;

import java.util.ServiceLoader;

/**
 * Created by yantong on 2019/3/2.
 *
 * {@link sun.security.provider.ConfigFile.Spi}
 *
 * 条件1：目录：classPath ？未测试 或 resrouce/META-INF/services/
 *      2:文件：packagePath.className
 *      3.内容：实现类：packagePath.className
 *
 * 样例：Mysql-connector-java:5.1.44 目录下有java.sql.Driver 文件
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
