package com.yt.restful.evolution.style.hierarchical;

import com.yt.restful.evolution.style.HierarchicalStyles;

/**
 * Created by yantong on 2019/2/20.
 */
public interface CS extends HierarchicalStyles {

    default String getFullName() {
        return "Client-Server";
    }
}
