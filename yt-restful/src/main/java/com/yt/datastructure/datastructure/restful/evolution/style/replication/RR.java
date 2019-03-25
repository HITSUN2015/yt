package com.yt.datastructure.datastructure.restful.evolution.style.replication;

import com.yt.datastructure.datastructure.restful.evolution.style.ReplicationStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface RR extends ReplicationStyles {

    default String getFullName() {
        return "Replicated Repository";
    }

}
