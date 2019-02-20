package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.PeerToPeerStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface EventBasedIntegrationStyle {

    default String getAbbreviation(){
        return "EBI";
    }
}
