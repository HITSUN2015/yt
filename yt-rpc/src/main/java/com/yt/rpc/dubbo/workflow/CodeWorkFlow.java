package com.yt.rpc.dubbo.workflow;

import com.alibaba.dubbo.common.extension.SPI;

import java.util.List;

/**
 * Created by yantong on 2019/3/5.
 */
public interface CodeWorkFlow {

    String getEffectiveClass();

    List<String> getEffectiveMethod();

    String getEffection();

}
