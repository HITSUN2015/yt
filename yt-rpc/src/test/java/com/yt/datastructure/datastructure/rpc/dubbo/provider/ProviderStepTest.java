package com.yt.datastructure.datastructure.rpc.dubbo.provider;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/3/1.
 */
@Test
public class ProviderStepTest {

    @Test
    public void test() {
        String resoucePath = "/application.xml";
        //
        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources" + resoucePath);
    }
}
