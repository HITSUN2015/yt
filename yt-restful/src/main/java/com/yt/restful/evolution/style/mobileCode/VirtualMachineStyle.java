package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.MobileCodeStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface VirtualMachineStyle extends MobileCodeStyles{

    default String getAbbreviation(){
        return "VM";
    }
}
