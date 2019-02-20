package com.yt.restful.evolution.style.mobileCode;

/**
 * Created by yantong on 2019/2/20.
 */
public interface MobileAgentStyle extends RemoteEvaluationStyle, CodeOnDemandStyle{

    default String getAbbreviation(){
        return "MA";
    }
}
