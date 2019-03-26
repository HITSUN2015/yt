package com.yt.restful.evolution;

import com.yt.restful.NetworkBasedHypermediaSystems;

/**
 * Created by yantong on 2019/2/20.
 */
@NetworkBasedHypermediaSystems
public interface NetworkBasedArchitecturalStyles
        extends NetworkBasedArchitecturalStylesAbbreviation, NetworkBasedApplication{

    /**
     * 风格的约束
     * 约束 是与style树形继承的
     * 所以 基类只需基类的style 实现约束函数
     */
    void limit();

}
