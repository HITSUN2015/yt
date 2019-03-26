package com.yt.restful.evolution.style.peerToPeer;

import com.yt.restful.evolution.style.hierarchical.LCS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface C2 extends EBI, LCS {

    default String getFullName(){
        return "C2";
    }
}
