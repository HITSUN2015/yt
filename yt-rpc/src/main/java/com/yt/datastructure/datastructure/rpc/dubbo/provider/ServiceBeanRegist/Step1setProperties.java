package com.yt.datastructure.datastructure.rpc.dubbo.provider.ServiceBeanRegist;

import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by yantong on 2019/3/1.
 *
 * 通过实现 {@link ApplicationContextAware} 补充properties的设置
 * 看了下这个接口，这个接口是 赋予bean功能，而非赋予容器功能，
 * 而且是在所有context都会调用的createBean方法下实现，所以建立测试的context时，不必考虑这个接口的implement
 * //实验室 调用最简单的 DefaultListableBeanFactory 确实不好使，并没有再细查了。。。 TODO
 *
 * TODO 需要用这个类 测试 下 都有什么方法 可以调用 都实现了 什么接口 ，已经 整个bean的生命周期
 */
//@Service
public class Step1setProperties implements ApplicationContextAware, InitializingBean, ApplicationListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 bean.setName 方法");
        this.name = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用 ApplicationContextAware.setApplicationContext 方法");
        //dubbo这张表里 为 serviceBean调用了 我看实现了context的addApplicationListener/addListener 接口 具体的调用对象 TODO
        //具体的内容有：
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 InitializingBean.afterPropertiesSet");

        //统一方法：在application 里 查找 某个类的接口
        //这部分代码 可以写的更漂亮
        //TODO  是不是这里 就可以看出 rpc 涉及的相关参数

        /**
         * 1.{@link ProviderConfig 子类}
         *
         * 2.{@link com.alibaba.dubbo.config.ApplicationConfig }\
         *
         * 3.{@link ModuleConfig}
         *
         * 4.{@link MonitorConfig}
         *
         * 5.{@link ProtocolConfig}
         *
         * 6.beanName
         *
         * 7.export
         */
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("调用 ApplicationListener.onApplicationEvent");
        /**
         * 监听了这个事件
         * {@link ContextRefreshedEvent}
         * &&条件 TODO
         * 会执行export()
         */
    }
}
