package com.yt.spring.ioc.xml;

/**
 * Created by yantong on 2019/2/28.
 * spring xml 是需要把spring xml 配置中的标签，变成spring container中的相关元素
 *
 * TODO 理解不清晰
 * 把xml变成bean 通常都需要解析
 * 这里把各种解析器 放在不同的命名空间里：
 *
 * 例如
 * 添加命名空间：xmlns:context="http://www.springframework.org/schema/context""
 * xml里就可以配置 <context:component-scan></context:component-scan>
 * NamespaceHandler
 * ->NamespaceHandlerSupport
 * ->ContextNamespaceHandler
 * ->registerBeanDefinitionParser("component-scan", new ComponentScanBeanDefinitionParser());
 *
 */
public interface SpringXML
{
}
