package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.hierarchical.LC$SS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LCODC$SS extends LC$SS, COD {

    default String getFullName(){
        return "Layered-Code-on-Demand-Client-Cache-Stateless-Server";
    }
}
