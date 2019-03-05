package com.yt.rpc.dubbo.framework.ioc;

import com.alibaba.dubbo.common.extension.Adaptive;

/**
 * Created by yantong on 2019/3/5.
 *
 * {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 *
 * 个人感觉 这个类 类似spring 的{@link org.springframework.beans.factory.BeanFactory}
 * 用来加载实现类
 *
 * //TODO 是否是单例
 * 每个ExtensionLoader 都有一个 ObjectFactory用来实现单例的获取
 * 一般获取一个bean的流程是：
 *
 * |           步骤
 * |-------------------------------------------------------------------------------
 * |获取 some Type of bean's extensionLoader [type 是个带有{@link com.alibaba.dubbo.common.extension.ExtensionLoader}注解的interface]
 * |          ExtensionLoader.getExtensionLoader(Protocol.class)
 *            {@link com.alibaba.dubbo.config.ReferenceConfig}.
 * |获取 ExtensionFactory.class（type） of bean's extensionLoader [type 是个带有{@link com.alibaba.dubbo.common.extension.ExtensionLoader}注解的interface]
 * |          ExtensionLoader.getExtensionLoader(ExtensionFactory.class)
 * |          {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 * |通过extensionLoader(ExtensionFactory.class) 获取ExtensionFactory bean实例
 * |          ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension()
 * |          {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 * |通过extensionLoader获取 可选的class [cachedDefaultName 存储SPI 注解中的value值 作为默认的实现类]
 * |                                    [cachedClasses 存储
 * |                                     读取 "META-INF/dubbo/",          TODO
 * |                                          "META-INF/dubbo/internal/", 内部
 * |                                          "META-INF/services/"        第三方
 * |                                     三个路径下的 type(interface name)文件内的class名称，key-value格式 @see dubbo_internal_file.bmp},{dubbo_ExtensionFactory.bmp}]
 * |                                     [会在遍历的过程中 生成 Class  <Class.forName()>
 * |                                       cachedAdaptiveClass 存储 带有{@link Adaptive}的class
 * |                                       cachedWrapperClasses 存储 没有{@link Adaptive}的class ]
 * |          loadExtensionClasses()
 * |          {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 * |          ExtensionFactory.class 的 cachedAdaptiveClass 被设置成 {@link com.alibaba.dubbo.common.extension.factory.AdaptiveExtensionFactory}
 * |通过extensionLoader获取 ExtensionFactory.class 实现类
 * |          createAdaptiveExtension()->injectExtension((T) getAdaptiveExtensionClass().newInstance())<Class.newInstance()>
 * |          {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 * |          生成的AdaptiveExtensionFactory.factories存放了 遍历过程中的两个Factory
 * |          AdaptiveExtensionFactory.factories 通过 getExtension()->createExtension()->clazz.newInstance()获取 {@link com.alibaba.dubbo.common.extension.factory.SpiExtensionFactory} 和 {@link com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory}
 * |
 * |回到第一步，Protocol类型的ExtensionLoader的objectFactory就是AdaptiveExtensionFactory的实例了
 * |
 * |通过ExtensionLoader<Protocol> createAdaptiveExtensionClassCode() 硬编程生成代码
 * |通过ExtensionLoader 生成 编译器：ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.common.compiler.Compiler.class)
 * |通过编译器 生成 class
 * |injectClass
 * |从而生成了Protocol实例：名称：Protocol$Adpative （这单词可能打错了。。。）{@link com.alibaba.dubbo.common.extension.ExtensionLoader} search($Adpative)
 *      我查下了下master 已经对着部分代码做了 更偏向面向对象编程的重构 TODO 可以自己先想想如何重构，再对比下
 */
public class ExtensionLoader {
}
