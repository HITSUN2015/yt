package com.yt.restful.evolution.style.hierarchical;

import com.yt.restful.evolution.style.replication.$;

/**
 * Created by yantong on 2019/2/20.
 */
public interface C$SS extends CSS, $ {

    default String getFullName(){
        return "Client-Cache-Stateless-Server";
    }
}
