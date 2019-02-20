package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.hierarchical.ClientServerStyle;

/**
 * Created by yantong on 2019/2/20.
 *
 * CS+CS
 */
public interface DistributedObjectsStyle extends ClientServerStyle{

    default String getAbbreviation(){
        return "DO";
    }
}
