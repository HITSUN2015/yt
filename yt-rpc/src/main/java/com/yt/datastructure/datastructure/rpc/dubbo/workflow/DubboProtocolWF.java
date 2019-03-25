package com.yt.datastructure.datastructure.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class DubboProtocolWF implements CodeWorkFlow{
    @Override
    public String getEffectiveClass() {
        return "DubboProtocol";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("export", "openServer", "createServer");
    }

    @Override
    public String getEffection() {
        return null;
    }
}
