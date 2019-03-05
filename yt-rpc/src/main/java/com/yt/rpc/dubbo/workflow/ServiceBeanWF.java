package com.yt.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class ServiceBeanWF implements CodeWorkFlow{

    @Override
    public String getEffectiveClass() {
        return "ServiceBean";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("afterPropertiesSet");
    }

    @Override
    public String getEffection() {
        return "spring 启动时，激活 dubbo-provider";
    }
}
