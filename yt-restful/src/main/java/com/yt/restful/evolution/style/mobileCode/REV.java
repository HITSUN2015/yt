package com.yt.restful.evolution.style.mobileCode;

import com.yt.restful.evolution.style.hierarchical.CS;

/**
 * Created by yantong on 2019/2/20.
 */
public interface REV extends CS, VM {

    default String getFullName(){
        return "Remote Evaluation";
    }
}
