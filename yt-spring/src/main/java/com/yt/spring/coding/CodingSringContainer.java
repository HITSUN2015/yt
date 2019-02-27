package com.yt.spring.coding;/**
 * Created by SUN on 19/2/27.
 */

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author SUN
 * @create 2019-02-27 下午9:31
 * @desc 编程实现springContainer
 */
public class CodingSringContainer {

    public DefaultListableBeanFactory createSpringApplication() {
        //获取 resources/coding/codingBean.xml 文件
        ClassPathResource res = new ClassPathResource("/coding/codingBean.xml");

        //new 空对象
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //创建文件ResourceReader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        //加载配置文件 bean的初始化
        reader.loadBeanDefinitions(res);
        return factory;
    }
}
