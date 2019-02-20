package com.yt.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface CSS extends CS {

    default String getFullName(){
        return "Client-Stateless-Server";
    }
}
