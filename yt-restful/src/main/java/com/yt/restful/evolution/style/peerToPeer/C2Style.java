package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.hierarchical.LayeredSystemAndLayeredClientServerStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface C2Style extends EventBasedIntegrationStyle, LayeredSystemAndLayeredClientServerStyle{

    default String getAbbreviation(){
        return "C2";
    }
}
