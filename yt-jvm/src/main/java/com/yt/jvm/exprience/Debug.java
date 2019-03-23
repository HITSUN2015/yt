package com.yt.jvm.exprience;

/**
 * Created by yantong on 2019/3/22.
 */
public class Debug {
    /**
     *
     -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000

     JAVA_OPTS="$JAVA_OPTS -XX:PermSize=128M -XX:MaxPermSize=256m -Xms1024m -Xmx1024m -Duser.timezone=Asia/Shanghai -server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 -Djava.awt.headless=true -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=22222 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false "
     */
}
