package com.yt.restful.evolution.propties.modifiability;

import com.yt.restful.evolution.propties.Modifiability;

/**
 * Created by yantong on 2019/2/20.
 * 可定制性
 * Customizability refers to the ability to temporarily specialize the behavior of an architectural element, such that it can then perform an unusual service. A component is customizable if it can be extended by one client of that component's services without adversely impacting other clients of that component [50]. Styles that support customization may also improve simplicity and scalability, since service components can be reduced in size and complexity by directly implementing only the most frequent services and allowing infrequent services to be defined by the client. Customizability is a property induced by the remote evaluation and code-on-demand styles.
 */
public interface Customizability extends Modifiability {
}
