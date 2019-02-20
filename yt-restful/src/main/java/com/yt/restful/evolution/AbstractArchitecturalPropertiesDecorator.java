package com.yt.restful.evolution;

/**
 * Created by yantong on 2019/2/20.
 */
public abstract class AbstractArchitecturalPropertiesDecorator implements NetworkBasedApplication{

    private NetworkBasedApplication networkApplication;

    public void setNetworkApplication(NetworkBasedApplication networkApplication) {
        this.networkApplication = networkApplication;
    }

    @Override
    public void evaluate() {
        networkApplication.evaluate();
    }
}
