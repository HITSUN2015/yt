package com.yt.datastructure.datastructure.restful.evolution.style.mobileCode;

/**
 * Created by yantong on 2019/2/20.
 */
public interface MA extends REV, COD {

    default String getFullName(){
        return "Mobile Agent";
    }
}
