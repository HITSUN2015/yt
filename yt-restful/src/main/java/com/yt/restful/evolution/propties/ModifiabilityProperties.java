package com.yt.restful.evolution.propties;

import com.yt.restful.evolution.ArchitecturalProperties;

/**
 * Created by yantong on 2019/2/20.
 * 可修改性
 * ModifiabilityProperties is about the ease with which a change can be made to an application architecture. ModifiabilityProperties can be further broken down into evolvability, extensibility, customizability, configurability, and reusability, as described below. A particular concern of network-based systems is dynamic modifiability [98], where the modification is made to a deployed application without stopping and restarting the entire system.

 Even if it were possible to build a software system that perfectly matches the requirements of its users, those requirements will change over time just as society changes over time. Because the components participating in a network-based application may be distributed across multiple organizational boundaries, the system must be prepared for gradual and fragmented change, where old and new implementations coexist, without preventing the new implementations from making use of their extended capabilities.
 */
public interface ModifiabilityProperties extends ArchitecturalProperties{
}
