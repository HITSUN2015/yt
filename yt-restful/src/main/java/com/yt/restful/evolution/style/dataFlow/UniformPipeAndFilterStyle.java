package com.yt.restful.evolution.style.dataFlow;

/**
 * Created by yantong on 2019/2/20.
 */
public interface UniformPipeAndFilterStyle extends PipeAndFilterStyle{

    default String getAbbreviation(){
        return "UPF";
    }
}
