package com.yt.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * Created by yantong on 2019/2/28.
 */
public interface BeanGetter {

    <T> T getBean(DefaultListableBeanFactory factory,String beanName, Class<T> tClass);
}
