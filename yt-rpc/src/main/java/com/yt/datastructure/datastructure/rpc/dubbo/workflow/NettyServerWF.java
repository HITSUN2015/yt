package com.yt.datastructure.datastructure.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class NettyServerWF implements CodeWorkFlow {
    @Override
    public String getEffectiveClass() {
        return "NettyServer";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("doOpen");
    }

    @Override
    public String getEffection() {
        return null;
    }
}
