package com.yt.datastructure.datastructure.restful.evolution.propties.modifiability;

import com.yt.datastructure.datastructure.restful.evolution.propties.ModifiabilityProperties;

/**
 * Created by yantong on 2019/2/20.
 * 可进化性
 * EvolvabilityProperty represents the degree to which a component implementation can be changed without negatively impacting other components. Static evolution of components generally depends on how well the architectural abstraction is enforced by the implementation, and thus is not something unique to any particular architectural style. Dynamic evolution, however, can be influenced by the style if it includes constraints on the maintenance and location of application state. The same techniques used to recover from partial failure conditions in a distributed system [133] can be used to support dynamic evolution.
 */
public interface EvolvabilityProperty extends ModifiabilityProperties {
}
