package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.hierarchical.CS;

/**
 * Created by yantong on 2019/2/20.
 *
 * CSApplication+CSApplication
 */
public interface DO extends CS {

    default String getFullName(){
        return "Distributed Objects";
    }
}
