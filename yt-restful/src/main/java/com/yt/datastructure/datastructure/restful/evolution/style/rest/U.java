package com.yt.datastructure.datastructure.restful.evolution.style.rest;

import com.yt.datastructure.datastructure.restful.evolution.style.RestStyles;

/**
 * Created by yantong on 2019/2/20.
 *
 *
 */
public interface U extends RestStyles {

    default String getFullName(){
        return "Uniform Interface";
    }
}
