package com.yt.datastructure.datastructure.restful.evolution;

/**
 * Created by yantong on 2019/2/20.
 */
public abstract class BaseNeworkApplication implements NetworkBasedApplication {

    protected EvaluateResultModel evaluateResultModel = new EvaluateResultModel();

    public BaseNeworkApplication() {
    }

    @Override
    public EvaluateResultModel evaluate() {
        return evaluateResultModel;
    }

}
