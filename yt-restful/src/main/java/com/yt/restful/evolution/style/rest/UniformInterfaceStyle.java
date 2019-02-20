package com.yt.restful.evolution.style.rest;

import com.yt.restful.evolution.style.RestStyles;

/**
 * Created by yantong on 2019/2/20.
 *
 *
 */
public interface UniformInterfaceStyle extends RestStyles {

    default String getAbbreviation(){
        return "U";
    }
}
