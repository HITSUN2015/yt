package com.yt.restful.evolution.style.dataFlow;

/**
 * Created by yantong on 2019/2/20.
 */
public interface UPF extends PF {

    default String getFullName() {
        return "Uniform Pipe and Filter";
    }

}
