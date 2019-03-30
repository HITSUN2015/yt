package com.yt.jdk.process.communicate.rmi.jdk.client;


import com.yt.jdk.process.communicate.rmi.jdk.api.RMIDemoService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by yantong on 2019/3/30.
 */
public class RMIDemoServiceClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", RMIDemoService.PORT);
            RMIDemoService rmiDemoService = (RMIDemoService)registry.lookup(RMIDemoService.SERVICE_NAME);
            String result = rmiDemoService.getTestString();
            System.out.println("rmi testString:【" + result + "】");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
