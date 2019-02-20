package com.yt.restful.evolution.style.hierarchical;

import com.yt.restful.evolution.style.replication.CacheStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface ClientCacheStatelessServerStyle extends ClientStatelessServerStyle, CacheStyle{

    default String getAbbreviation(){
        return "C$SS";
    }
}
