package com.yt.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LayeredClientCacheStatelessServerStyle extends LayeredSystemAndLayeredClientServerStyle, ClientCacheStatelessServerStyle{
    default String getAbbreviation(){
        return "LC$SS";
    }
}
