package com.yt.restful.evolution.style.rest;

import com.yt.restful.evolution.style.mobileCode.LCODC$SS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface REST extends LCODC$SS, U {

    default String getFullName(){
        return "Representational State Transfer";
    }
}
