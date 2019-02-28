package com.yt.spring.ioc;

import com.yt.spring.application.CodingSringContainer;
import com.yt.spring.ioc.annotation.BeanByAnnotation;
import com.yt.spring.ioc.config.BeanByConfiger;
import com.yt.spring.ioc.config.ConfigurationBeanModel;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/28.
 */
public class BeanByConfigurationTest {

    @Test
    public void testConfigurationBeanIOC() {
        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/application/applicaiton_ioc_configuration.xml");

        //如下这行也可用 但是不支持 xml配置 没有开启注解扫描
        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanByConfiger.class);

        ConfigurationBeanModel bean = applicationContext.getBean("configurationBeanModel", ConfigurationBeanModel.class);

        System.out.println(bean);
    }
}
