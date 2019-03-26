package com.yt.spring.ioc.xml;

import com.yt.spring.ioc.BeanGetter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * Created by yantong on 2019/2/28.
 */
public class BeanByXML implements BeanGetter {

    @Override
    public <T> T getBean(DefaultListableBeanFactory factory, String beanName, Class<T> tClass) {
        if (null == factory) {
            return null;
        }

        //此BeanDefination已经携带有 xml配置的属性值
        BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);

        //调用此方法, 根据 beanDefinition,用bean的构造函数,创建了bean对象(我本地测试 KotlinDetector.isKotlinReflectPresent() = false)
        T codingModel = factory.getBean(beanName, tClass);

        return codingModel;
    }
}
