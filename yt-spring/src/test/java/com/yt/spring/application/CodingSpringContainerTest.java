package com.yt.spring.application;/**
 * Created by SUN on 19/2/27.
 */

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.Assert;
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

        DefaultListableBeanFactory factory = contailner.createSpringApplication("/application/applicaton_ioc_xml.xml");

        Assert.notNull(factory);
    }
}
