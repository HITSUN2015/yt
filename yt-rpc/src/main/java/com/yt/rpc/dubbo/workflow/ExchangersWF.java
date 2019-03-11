package com.yt.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class ExchangersWF implements CodeWorkFlow {
    @Override
    public String getEffectiveClass() {
        return "Exchangers";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("bind");
    }

    @Override
    public String getEffection() {
        return null;
    }
}
