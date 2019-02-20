package com.yt.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface RemoteSessionStyle extends ClientServerStyle{

    default String getAbbreviation(){
        return "RS";
    }
}
