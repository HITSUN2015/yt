package com.yt.restful.evolution.propties.modifiability;

import com.yt.restful.evolution.AbstractArchitecturalPropertiesDecorator;

/**
 * Created by yantong on 2019/2/20.
 */
public class ExtensibilityPropertyDecorator extends AbstractArchitecturalPropertiesDecorator {

    @Override
    protected void decorate() {
        this.evaluateResult.setExtensibilityPropertyValue(1);
    }
}
