package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.hierarchical.LayeredSystemAndLayeredClientServerStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface BrokeredDistributedObjectsStyle extends DistributedObjectsStyle, LayeredSystemAndLayeredClientServerStyle{

    default String getAbbreviation(){
        return "BDO";
    }
}
