package com.yt.restful.evolution.style.dataFlow;

import com.yt.restful.evolution.style.DataFlowStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface PF extends DataFlowStyles {

    default String getFullName() {
        return "Pipe and Filter";
    }

}
