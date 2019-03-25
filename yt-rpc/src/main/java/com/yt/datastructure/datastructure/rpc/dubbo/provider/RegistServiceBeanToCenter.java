package com.yt.datastructure.datastructure.rpc.dubbo.provider;

import com.alibaba.dubbo.config.spring.schema.DubboBeanDefinitionParser;

/**
 *
 * 1.解析xml：
 *  {@link DubboBeanDefinitionParser}.parse 生成 {@link org.springframework.beans.factory.config.BeanDefinition}
 *      该对象：
 *      beanClass:com.alibaba.dubbo.config.spring.ServiceBean
 *      propertyValues:id,ref,interface,version,delay,timeout,async等主要参数
 * 2.{@link com.alibaba.dubbo.config.spring.ServiceBean}
 *      这里建议查看该类的方法时，打开Structure-Interface
 *      了解为什么要实现该接口
 *
 *      afterPropertiesSet补充参数：（debug一次即可）
 *       ProviderConfig provider：有没有配置dubbo:provider
 *       ApplicationConfig application：有没有配置dubbo:application
 *       ModuleConfig module：有没有配置dubbo:module
 *       List registries：有没有配置dubbo:registry
 *       MonitorConfig monitor：有没有配置dubbo:monitor
 *       List protocols：有没有配置dubbo:protocol
 *       String path：服务名称
 *    export()暴露服务
 */
public interface RegistServiceBeanToCenter {
}
