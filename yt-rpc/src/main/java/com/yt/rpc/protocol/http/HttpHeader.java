package com.yt.rpc.protocol.http;


/**
 * Created by yantong on 2019/3/26.
 * <p>
 * from https://zh.wikipedia.org/wiki/HTTP%E5%A4%B4%E5%AD%97%E6%AE%B5#cite_note-7
 * <p>
 * 标准中没有对每个协议头字段的名称和值的大小设置任何限制，也没有限制字段的个数
 * Apache 2.3服务器在默认情况下限制每个字段的大小不得超过8190字节，同时，单个请求中最多有100个头字段
 * <p>
 * demo:
 * <p>
 * 可自定义值
 */
public class HttpHeader {

    private String DEMO =
            "Accept:image/webp,image/*,*/*;q=0.8\n" +
                    "Accept-Encoding:gzip, deflate, sdch, br\n" +
                    "Accept-Language:en-US,en;q=0.8\n" +
                    "Connection:keep-alive\n" +
                    "Cookie:PSTM=1466499789; BAIDUID=D3A617EE01FFA9DB9B7E3E5F0D3A01EE:FG=1; BIDUPSID=4AA34EC11075CB66B8BC9792DD422B6F; BDUSS=VCc1M0cVQtYnFGfmxTUW5kVTUydnBZUmhiWFRXbnRlMnpIdWV2ODVxNHZ1WkZYQVFBQUFBJCQAAAAAAAAAAAEAAADkEA1ZtPO3rMfRt6zH0cfRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC8salcvLGpXdz; BD_HOME=1; BD_UPN=123353; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; BD_CK_SAM=1; H_PS_PSSID=19292_18286_1458_20318_18241_20369_17942_20388_19690_20417_18560_17001_15560_12277_20253; BDSVRTM=0\n" +
                    "Host:www.baidu.com\n" +
                    "Referer:https://www.baidu.com/s?wd=http%20%E8%AF%B7%E6%B1%82%E6%95%B0%E6%8D%AE%E7%9A%84%E6%95%B0%E6%8D%AE%E5%8C%85%E6%A0%BC%E5%BC%8F&rsv_spt=1&rsv_iqid=0x9b746a8000022af9&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=1&oq=http%20%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8Fpost%20url%E6%A0%BC%E5%BC%8F&rsv_t=59fb7cEn5xgK8JFpqQ7F7coy6k6dn5sGpEMj1cDM4oMoy0TGArJ2l3fxOqy6F9lXoqoi&inputT=7936&rsv_pq=ca5859d100027005&rsv_sug3=73&rsv_sug1=12&rsv_sug7=100&rsv_sug2=0&rsv_sug4=32020\n" +
                    "User-Agent:Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36";

    /**
     * 自定义字段
     */
    public void setHttpHeader(String key, String value) {
        // TODO: 2019/3/26
    }
}
