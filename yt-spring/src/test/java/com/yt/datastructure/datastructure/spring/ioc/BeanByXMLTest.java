package com.yt.datastructure.datastructure.spring.ioc;

import com.yt.datastructure.datastructure.spring.application.CodingSringContainer;
import com.yt.datastructure.datastructure.spring.ioc.xml.BeanByXML;
import com.yt.datastructure.datastructure.spring.ioc.xml.XMLBeanModel;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.testng.annotations.Test;

/**
 * Created by yantong on 2019/2/28.
 */
@Test
public class BeanByXMLTest {

    @Test
    public void testXmlBeanIOC() {
        DefaultListableBeanFactory factory = new CodingSringContainer().createSpringApplication("/application/applicaton_ioc_xml.xml");
        BeanGetter beanGetter = new BeanByXML();
        XMLBeanModel bean = beanGetter.getBean(factory, "codingIOCBeanName", XMLBeanModel.class);
        System.out.println(bean);
    }
}
