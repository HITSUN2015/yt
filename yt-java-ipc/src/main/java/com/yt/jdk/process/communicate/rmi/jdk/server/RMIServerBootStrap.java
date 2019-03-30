package com.yt.jdk.process.communicate.rmi.jdk.server;


import com.yt.jdk.process.communicate.rmi.jdk.api.RMIDemoService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by yantong on 2019/3/30.
 */
public class RMIServerBootStrap {

    public static void main(String[] args) {
        try {
            RMIDemoService rmiDemoServiceImpl = new RMIDemoServiceServerImpl();
            RMIDemoService rmiDemoService =
                    (RMIDemoService) UnicastRemoteObject.exportObject(rmiDemoServiceImpl,0);// TODO: 2019/3/30 port ?
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(RMIDemoService.PORT);
            registry.rebind(RMIDemoService.SERVICE_NAME, rmiDemoService);
            System.out.println("server start SUCCESS");
        } catch (RemoteException e) {
            System.out.println("server start FAILED");
            e.printStackTrace();
        }


    }
}
