package com.yt.datastructure.datastructure.restful.evolution.propties.performance;

import com.yt.datastructure.datastructure.restful.evolution.propties.PerformanceProperties;

/**
 * Created by yantong on 2019/2/20.
 * 网络性能
 * Network performance measures are used to describe some attributes of communication. Throughput is the rate at which information, including both application data and communication overhead, is transferred between components. Overhead can be separated into initial setup overhead and per-interaction overhead, a distinction which is useful for identifying connectors that can share setup overhead across multiple interactions (amortization). Bandwidth is a measure of the maximum available throughput over a given network link. Usable bandwidth refers to that portion of bandwidth which is actually available to the application.

 Styles impact network performance by their influence on the number of interactions per user action and the granularity of data elements. A style that encourages small, strongly typed interactions will be efficient in an application involving small data transfers among known components, but will cause excessive overhead within applications that involve large data transfers or negotiated interfaces. Likewise, a style that involves the coordination of multiple components arranged to filter a large data stream will be out of place in an application that primarily requires small control messages.
 */
public interface NetworkPerformanceProperty extends PerformanceProperties {
}
