package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.MobileCodeStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface VM extends MobileCodeStyles {

    default String getFullName(){
        return "Virtual Machine";
    }
}
