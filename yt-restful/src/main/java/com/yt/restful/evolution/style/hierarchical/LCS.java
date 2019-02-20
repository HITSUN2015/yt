package com.yt.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LCS extends CS,LS {

    default String getFullName() {
        return "Layered System and Layered-Client-Server";
    }

}
