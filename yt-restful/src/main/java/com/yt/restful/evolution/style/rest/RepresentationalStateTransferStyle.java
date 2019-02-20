package com.yt.restful.evolution.style.rest;

import com.yt.restful.evolution.style.mobileCode.LayeredCodeOnDemandClientCacheStatelessServerStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface RepresentationalStateTransferStyle
        extends LayeredCodeOnDemandClientCacheStatelessServerStyle, UniformInterfaceStyle{

    default String getAbbreviation(){
        return "REST";
    }
}
