package com.yt.jdk.process.communicate.rmi.jdk.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by yantong on 2019/3/30.
 */
public interface RMIDemoService extends Remote {

    //这个 可以 私下里 约定好
    String SERVICE_NAME = "rmiDemoService";
    int PORT = 2002;

    /**
     * 如果 不 throw {@link RemoteException}
     *      会抛出 java.lang.IllegalArgumentException: illegal remote method encountered
     */
    String getTestString() throws RemoteException;

}
