package com.yt.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LayeredSystemAndLayeredClientServerStyle extends ClientServerStyle,LayeredSystem {

    default String getAbbreviation(){
        return "LCS";
    }
}
