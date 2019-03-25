package com.yt.datastructure.datastructure.restful.evolution.style.hierarchical;

/**
 * Created by yantong on 2019/2/20.
 */
public interface RS extends CS {

    default String getFullName(){
        return "Remote Session";
    }
}
