package com.yt.restful.evolution.propties;

import com.yt.restful.evolution.ArchitecturalProperties;

/**
 * Created by yantong on 2019/2/20.
 * 可伸缩性
 * ScalabilityProperties refers to the ability of the architecture to support large numbers of components, or interactions among components, within an active configuration. ScalabilityProperties can be improved by simplifying components, by distributing services across many components (decentralizing the interactions), and by controlling interactions and configurations as a result of monitoring. Styles influence these factors by determining the location of application state, the extent of distribution, and the coupling between components.

 ScalabilityProperties is also impacted by the frequency of interactions, whether the load on a component is distributed evenly over time or occurs in peaks, whether an interaction requires guaranteed delivery or a best-effort, whether a request involves synchronous or asynchronous handling, and whether the environment is controlled or anarchic (i.e., can you trust the other components?).
 */
public interface ScalabilityProperties extends ArchitecturalProperties {
}
