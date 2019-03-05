package com.yt.rpc.dubbo.framwork;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author SUN
 * @create 2019-03-03 上午11:26
 * @desc 支撑dubbo各个工作流程实现的可扩展性
 *
 * {@link com.alibaba.dubbo.common.extension.ExtensionLoader}
 *
 * //我以前写过类似计算引擎的小框架,那时加载数据、连表、计算、输出我都放在一个大类里,挨个顺序调用
 * //
 * //我那时以为的是,如果我再需要别的实现方法,只需要添加实现类即可
 * //
 * //这里给出的思想是,如果你的小框架做的很好了,作为一个包给别人去依赖,别人来实现各自的方法,
 * //但是还无需从你的主干上弄出很多小分支。。。别人的扩展点,不会侵入到你的代码里。
 * //这个需求,就可以由SPI来实现了,当然,这个方法,应该仅建立在你确定你的框架能够流传。。。并且作为一个最base的版本~
 *
 * 有三种ExtensionLoader
 * 在{@link com.alibaba.dubbo.common.extension.ExtensionLoader} 已经给出解释
 * @see com.alibaba.dubbo.common.extension.SPI 最一般的ExtensionLoader
 * @see com.alibaba.dubbo.common.extension.Adaptive TODO
 * @see com.alibaba.dubbo.common.extension.Activate TODO
 *
 * 1.一般的实现,可能是:把默认的(都喜欢自己的与众不同)实现写在代码里,扩展的去用SPI机制
 *  而作者的意思是,既然都是加载实现类,自己的也用SPI的好了~
 *      化简了加载过程的代码量:否则必然有两种(一种是非SPI),
 *      当然也带来了代码阅读的困难
 * 2.既然 目前把ExtensionLoader理解为了一个类似Spring {@link org.springframework.beans.factory.BeanFactory}的东西
 *   那么ExtensionLoader就要解决IOC问题了
 *   spring是把对象转换成{@link org.springframework.beans.factory.config.BeanDefinition}
 *   再装到beanFactory里,那dubbo是怎么做的那?
 *
 *   TODO dubbo 组件为什么本身不作为spring的beans
 *
 *
 *
 *
 *
 *
 */
public class DubboWorkFlowImplExtensionSupport {

    public void test() {
        //必须是 interface
        //必须有SPI标识
        ExtensionLoader loader = ExtensionLoader.getExtensionLoader(DubboSPISExtend.class);
        Object object = loader.getLoadedExtensions();
        System.out.println(object);
    }


}
