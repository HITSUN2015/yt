package com.yt.datastructure.datastructure.restful.evolution.style.peerToPeer;

import com.yt.datastructure.datastructure.restful.evolution.style.hierarchical.LCS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface BDO extends DO, LCS {

    default String getFullName(){
        return "Brokered Distributed Objects";
    }
}
