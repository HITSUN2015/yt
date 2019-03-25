package com.yt.datastructure.datastructure.restful.evolution.style.mobileCode;

import com.yt.datastructure.datastructure.restful.evolution.style.hierarchical.CS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface COD extends CS, VM {

    default String getFullName(){
        return "Code on Demand";
    }
}
