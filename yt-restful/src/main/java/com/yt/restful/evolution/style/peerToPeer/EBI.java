package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.PeerToPeerStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface EBI extends PeerToPeerStyles {

    default String getFullName(){
        return "Event-based Integration";
    }
}
