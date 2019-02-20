package com.yt.restful.evolution.propties.performance;

import com.yt.restful.evolution.AbstractArchitecturalPropertiesDecorator;

/**
 * Created by yantong on 2019/2/20.
 */
public class NetworkEfficiencyPropertyDecorator extends AbstractArchitecturalPropertiesDecorator {
    @Override
    protected void decorate() {
        this.evaluateResult.setNetworkEfficiencyPropertyValue(1);
    }
}
