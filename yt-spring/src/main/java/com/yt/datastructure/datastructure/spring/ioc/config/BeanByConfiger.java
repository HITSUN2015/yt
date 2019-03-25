package com.yt.datastructure.datastructure.spring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.*;
import org.springframework.stereotype.Component;

/**
 * Created by yantong on 2019/2/28.
 */
//实验是 如果是 AnnotationConfigApplicationContext 直接 调用了这个类来生成 context
//则这里并不需要 配置 @Configuration 和 @Component 来生成Bean
/**
 * 实现@Bean的方法：
 * ->{@link AbstractApplicationContext}.refresh()
 * ->{@link PostProcessorRegistrationDelegate}.invokeBeanDefinitionRegistryPostProcessors}.
 * ->{@link AbstractApplicationContext}.invokeBeanFactoryPostProcessors
 * ->{@link ConfigurationClassBeanDefinitionReader}.loadBeanDefinitions
 * ->{@link ConfigurationClassBeanDefinitionReader}.loadBeanDefinitionsForConfigurationClass
 * ->{@link ConfigurationClassBeanDefinitionReader}.loadBeanDefinitionsForBeanMethod
 * 大致原理是 先加载一般的类，然后再从这些类里找，是否有Bean注释的方法来加载类
 *
 * 这里解释了 为什么 我用 {@link org.springframework.beans.factory.support.DefaultListableBeanFactory}
 * 通过加载/application/applicaiton_ioc_configuration.xml 并没有 生成 @Bean的原因，因为 该类并非继承自 AbstractApplicationContext
 * 后来就在 BeanByConfigurationTest 类中 随意找了个支持XML的AbstractApplicationContext子类  {@link FileSystemXmlApplicationContext} 来实现xml文件导入 且扫描注解来加载这bean
 * 记得：AnnotationConfigApplicationContext 不需要导入xml ，所以可以不用 @Component
 * @Bean是依赖他所在的类 已经是 spring容器中的bean的前提的，所以需要加@Component 或其子注解
 */
@Component
public class BeanByConfiger {

    //bean的名称就是 方法名 大小写（包括首字母）不兼容
    @Bean
    public ConfigurationBeanModel configurationBeanModel() {
        ConfigurationBeanModel configurationBeanModel = new ConfigurationBeanModel();
        configurationBeanModel.setPrice(1);
        configurationBeanModel.setTitle("ConfigurationBeanModel title");
        return configurationBeanModel;
    }
}
