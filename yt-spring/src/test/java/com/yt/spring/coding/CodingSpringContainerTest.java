package com.yt.spring.coding;/**
 * Created by SUN on 19/2/27.
 */

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * @author SUN
 * @create 2019-02-27 下午9:41
 * @desc 测试 编程IOC Container类
 */
@Test
public class CodingSpringContainerTest {

    @Test
    public void testCodingIOC() {
        CodingSringContainer contailner = new CodingSringContainer();

        DefaultListableBeanFactory factory = contailner.createSpringApplication();

        //此BeanDefination已经携带有 xml配置的属性值
        BeanDefinition beanDefinition = factory.getBeanDefinition("codingIOCBeanName");

        //调用此方法, 根据 beanDefinition,用bean的构造函数,创建了bean对象(我本地测试 KotlinDetector.isKotlinReflectPresent() = false)
        CodingModel codingModel = factory.getBean("codingIOCBeanName", CodingModel.class);

        System.out.println(codingModel);
    }
}
