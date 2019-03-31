package com.yt.net.osi.transport.tcp;/**
 * Created by SUN on 19/3/31.
 */

/**
 * @author SUN
 * @create 2019-03-31 下午3:42
 * @desc
 */
public class TCPConnectionModel {
    /**
     * tcp六个标志位
     */
    private int SYN;    //synchronous 建立联机
    private int ACK;    //acknowledgement 确认
    private int PSH;    //push传送
    private int FIN;    //finish结束
    private int RST;    //reset重置
    private int URG;    //urgent紧急

    private String seq = "sequence number 顺序号码";
    private String AcknowledgeNumber = "Acknowledge number 确认号码";
}
