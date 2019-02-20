package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.hierarchical.ClientServerStyle;

/**
 * Created by yantong on 2019/2/20.
 */
public interface CodeOnDemandStyle extends ClientServerStyle, VirtualMachineStyle {

    default String getAbbreviation(){
        return "COD";
    }
}
