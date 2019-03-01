package com.yt.rpc.dubbo.provider;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.config.spring.schema.DubboNamespaceHandler;
import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 1.应用spring 即可可以生成bean 但是dubbo这里将所有需要暴露服务的封装成了特殊的bean，来支持RPC相关的功能
 *
 * 2.如何非侵入的把普通spring bean封装成 dubbo属性的bean TODO 这是 container中有几个有同样服务的bean？
 *
 * 3.如何加载 nameSpaceParser
 *      {@link org.springframework.context.support.AbstractApplicationContext}.refresh()
 *      {@link DefaultNamespaceHandlerResolver}.resolve()
 *
 *      这里有个 Map<String, Object> handlerMappings = getHandlerMappings()
 *      是 namespaceUri -> NamespaceHandler
 *      这个map是 由 Properties mappings = PropertiesLoaderUtils.loadAllProperties(this.handlerMappingsLocation, this.classLoader);
 *      this.handlerMappingsLocation = "META-INF/spring.handlers"
 *      查看dubbo项目：jar/META-INF/spring-handlers/
 *          写有：http\://code.alibabatech.com/schema/dubbo=com.alibaba.dubbo.config.spring.schema.DubboNamespaceHandler
 *
 * 4.扩展 {@link NamespaceHandlerSupport}
 *      进而会调用{@link DubboNamespaceHandler}.init()
*       code:registerBeanDefinitionParser("service", new DubboBeanDefinitionParser(ServiceBean.class, true));
 *      可以将dubbo-service标签变成springbean了，这种bean带有了额外的功能：
 *
 *      {@link ServiceBean}
 *
 */
public interface TransferXMLToServiceBean {

}
