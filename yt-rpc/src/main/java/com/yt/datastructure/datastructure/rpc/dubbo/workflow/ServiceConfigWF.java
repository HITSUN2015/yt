package com.yt.datastructure.datastructure.rpc.dubbo.workflow;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public class ServiceConfigWF implements CodeWorkFlow {

    @Override
    public String getEffectiveClass() {
        return "ServiceConfig<T>";
    }

    @Override
    public List<String> getEffectiveMethod() {
        return Lists.newArrayList("export", "doExport", "doExportUrls", "doExportUrlsFor1Protocol",
                "exportLocal略，暴露本地服务，injvmProtocol共本地使用");
    }

    @Override
    public String getEffection() {
        return null;
    }
}
