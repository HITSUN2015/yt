package com.yt.restful.evolution.style.replication;

/**
 * Created by yantong on 2019/2/20.
 */
public interface CacheStyle extends ReplicatedRepositoryStyle {

    default String getAbbreviation(){
        return "$";
    }
}
