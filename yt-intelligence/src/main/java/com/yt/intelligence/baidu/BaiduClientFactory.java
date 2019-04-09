package com.yt.intelligence.baidu;/**
 * Created by SUN on 19/4/9.
 */

import com.baidu.aip.face.AipFace;

/**
 * @author SUN
 * @create 2019-04-09 下午10:20
 * @desc
 */
public class BaiduClientFactory {

    private static AipFace clientInstance;

    //设置APPID/AK/SK
    public static final String APP_ID = "15976232";
    public static final String API_KEY = "DmcLcBkLRZdN2MrlesGHGpUM";
    public static final String SECRET_KEY = "RLkghoFzmoW8kf7vaTWLH5jOMDe5YsQf";

    public static AipFace intance() {
        if (null == clientInstance) {
            synchronized (BaiduClientFactory.class) {
                if (null == clientInstance) {
                    clientInstance = new AipFace(APP_ID, API_KEY, SECRET_KEY);

                    // 可选：设置网络连接参数
                    clientInstance.setConnectionTimeoutInMillis(2000);
                    clientInstance.setSocketTimeoutInMillis(60000);

                    // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
                    //        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
                    //        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

                    // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
                    // 也可以直接通过jvm启动参数设置此环境变量
                    //        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
                }
            }
        }
        return clientInstance;
    }
}
