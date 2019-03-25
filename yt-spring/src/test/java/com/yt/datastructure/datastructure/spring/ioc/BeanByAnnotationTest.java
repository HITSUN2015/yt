package com.yt.datastructure.datastructure.spring.ioc;

import com.yt.datastructure.datastructure.spring.application.CodingSringContainer;
import com.yt.datastructure.datastructure.spring.ioc.annotation.BeanByAnnotation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/28.
 */
public class BeanByAnnotationTest {

    @Test
    public void testAnnotationBeanIOC() {
        DefaultListableBeanFactory factory = new CodingSringContainer().createSpringApplication("/application/application_ioc_annotation.xml");

        BeanDefinition beanDefinition = factory.getBeanDefinition("beanByAnnotation");

        //这里自动注入的 bean name如果没有被明确指明，则为类名小写字母开头
        BeanByAnnotation bean = factory.getBean("beanByAnnotation", BeanByAnnotation.class);
        System.out.println(bean);
    }
}
