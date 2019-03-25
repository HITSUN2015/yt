package com.yt.datastructure.datastructure.linux.command;

import com.yt.datastructure.datastructure.linux.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yantong on 2019/3/22.
 */
public class Curl {

    private String ip;
    private Integer port;

    private String url;
    private Map<String, String> headParams;

    private void check() {
        if (null == ip || ip.isEmpty()) {
            throw new IllegalArgumentException("ip is empty");
        }
        if (null == port) {
            throw new IllegalArgumentException("port is empty");
        }
        if (null == url || url.isEmpty()) {
            throw new IllegalArgumentException("url is empty");
        }
    }

    public Curl(String ip, Integer port, String url) {
        this.ip = ip;
        this.port = port;
        this.url = url;
    }

    public int setHeader(String key, String value) {
        if (null != key && !key.isEmpty()) {
            if (headParams == null) {
                headParams = new HashMap<>();
            }
            headParams.put(key, value);
            return ResultEnum.OK.value();
        }
        return ResultEnum.ERROR.value();
    }

    public String buildResult() {
        check();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("curl '")
                .append(ip).append(":").append(port).append(url).append("'");
        if (null != headParams && !headParams.isEmpty()) {
            stringBuilder.append(" -H '");
            headParams.forEach((x, y) -> stringBuilder.append(x).append(":").append(y));
            stringBuilder.append("'");
        }
        return stringBuilder.toString();
    }
    public void get() {
        String command = "curl '10.97.103.66:8080/v3/faceservice/strangersDynamic?deviceSerial=181551089&offset=0&channelNo=1&limit=40&shareStatus=-1' -H 'zuulUserId:96abe6c2eed04fbfafe1ec546b7f0042'";

    }
}
