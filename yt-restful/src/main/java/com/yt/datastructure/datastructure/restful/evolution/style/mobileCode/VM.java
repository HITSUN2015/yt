package com.yt.datastructure.datastructure.restful.evolution.style.mobileCode;

import com.yt.datastructure.datastructure.restful.evolution.style.MobileCodeStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface VM extends MobileCodeStyles {

    default String getFullName(){
        return "Virtual Machine";
    }
}
