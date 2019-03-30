package com.yt.jdk.process.communicate.rmi.jdk.server;


import com.yt.jdk.process.communicate.rmi.jdk.api.RMIDemoService;

/**
 * Created by yantong on 2019/3/30.
 */
public class RMIDemoServiceServerImpl implements RMIDemoService {

    public static final String DEFAULT_STRING = "TEST_SRING";

    @Override
    public String getTestString() {
        return DEFAULT_STRING;
    }
}
