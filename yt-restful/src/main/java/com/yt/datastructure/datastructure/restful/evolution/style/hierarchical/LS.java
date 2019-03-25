package com.yt.datastructure.datastructure.restful.evolution.style.hierarchical;

import com.yt.datastructure.datastructure.restful.evolution.style.HierarchicalStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface LS extends HierarchicalStyles {

    default String getFullName() {
        return "Layered System";
    }
}
