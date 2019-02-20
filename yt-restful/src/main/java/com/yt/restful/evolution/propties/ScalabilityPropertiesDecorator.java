package com.yt.restful.evolution.propties;

import com.yt.restful.evolution.AbstractArchitecturalPropertiesDecorator;

/**
 * Created by yantong on 2019/2/20.
 */
public class ScalabilityPropertiesDecorator extends AbstractArchitecturalPropertiesDecorator {

    @Override
    protected void decorate() {
        this.evaluateResult.setScalabilityPropertiesValue(1);
    }
}
