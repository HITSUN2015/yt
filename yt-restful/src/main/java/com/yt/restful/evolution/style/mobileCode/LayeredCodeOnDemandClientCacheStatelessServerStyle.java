package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.hierarchical.LayeredClientCacheStatelessServerStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LayeredCodeOnDemandClientCacheStatelessServerStyle
        extends LayeredClientCacheStatelessServerStyle, CodeOnDemandStyle{

    default String getAbbreviation(){
        return "LCODC$SS";
    }
}
