package com.yt.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class RegistryProtocolWF implements CodeWorkFlow{
    @Override
    public String getEffectiveClass() {
        return "RegistryProtocol";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("export", "doLocalExport");
    }

    @Override
    public String getEffection() {
        return null;
    }
}
