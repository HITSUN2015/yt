package com.yt.jdk.process.communicate.jmx.client;

import com.yt.jdk.process.communicate.jmx.mbean.JMXDemoMXBean;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yantong on 2019/3/30.
 */
public class JMXDemoClient {

    public static void main(String[] args) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put(JMXConnector.CREDENTIALS, "jmxDemo");
        JMXServiceURL url = null;
        try {
            url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
            JMXConnector conn = JMXConnectorFactory.connect(url, prop);
            MBeanServerConnection mbsc = conn.getMBeanServerConnection();
            ObjectName mbeanName = new ObjectName("com.yt.jdk.process.communicate.jmx.mbean:name=jmxDemo");
            JMXDemoMXBean jmxDemoMXBean = JMX.newMBeanProxy(mbsc, mbeanName, JMXDemoMXBean.class);
            System.out.println(jmxDemoMXBean.getTestString());
        } catch (MalformedURLException e) {
                e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
