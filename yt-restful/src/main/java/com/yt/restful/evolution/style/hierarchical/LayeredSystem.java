package com.yt.restful.evolution.style.hierarchical;

import com.yt.restful.evolution.style.HierarchicalStyles;

/**
 * Created by yantong on 2019/2/20.
 * 这个风格 并未单独提出
 */
public interface LayeredSystem extends HierarchicalStyles {

    default String getAbbreviation(){
        return "LS";
    }
}
