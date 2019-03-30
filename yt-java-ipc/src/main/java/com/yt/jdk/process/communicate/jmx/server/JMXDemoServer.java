package com.yt.jdk.process.communicate.jmx.server;

import com.yt.jdk.process.communicate.jmx.mbean.JMXDemoMXBean;
import com.yt.jdk.process.communicate.jmx.mbean.JMXDemoMXBeanImpl;

import javax.management.*;
import javax.management.remote.JMXAuthenticator;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.security.auth.Subject;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;

/**
 * Created by yantong on 2019/3/30.
 */
public class JMXDemoServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            MBeanServer server = MBeanServerFactory.createMBeanServer();

            ObjectName helloName = new ObjectName("com.yt.jdk.process.communicate.jmx.mbean:name=jmxDemo");
            JMXDemoMXBean jmxDemoMXBean = new JMXDemoMXBeanImpl();
            HashMap<String, Object> prop = new HashMap<String, Object>();
            prop.put(JMXConnectorServer.AUTHENTICATOR, new JMXAuthenticator() {
                public Subject authenticate(Object credentials) {
                    if (credentials instanceof String) {
                        if (credentials.equals("jmxDemo")) {
                            return new Subject();
                        }
                    }
                    throw new SecurityException("not authicated");
                }
            });
            JMXConnectorServer cserver = JMXConnectorServerFactory
                    .newJMXConnectorServer(new JMXServiceURL(
                                    "service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi"),
                            prop, server);
            cserver.start();
            server.registerMBean(jmxDemoMXBean, helloName);
            for (ObjectInstance object : server.queryMBeans(null, null)) {
                System.out.println(object.getObjectName());
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }
}
