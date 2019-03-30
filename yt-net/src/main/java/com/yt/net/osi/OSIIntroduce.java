package com.yt.net.osi;

import com.yt.net.osi.dataLink.OSIDataLinkLayerIntroduce;

/**
 * Created by yantong on 2019/3/30.
 *
 * Open System Interconnection
 *  参考模型是国际标准化组织（ISO）制定的一个用于计算机或通信系统间互联的标准体系
 *  不仅包括一系列抽象的术语或概念，也包括具体的协议
 *
 * 1.物理层 {@link com.yt.net.osi.physical.OSIPhysicalLayerIntroduce}
 * 2.数据链路层 {@link OSIDataLinkLayerIntroduce}
 * 3.网络层 {@link com.yt.net.osi.network.OSINetworkLayerIntroduce}
 * 4.数据传输层 {@link com.yt.net.osi.transport.OSITransportLayerIntroduce}
 * 5.会话层 {@link com.yt.net.osi.session.OSISessionLayerIntroduce}
 * 6.表达层 {@link com.yt.net.osi.presentation.OSIPresentationLayerIntroduce}
 * 7.应用层 {@link com.yt.net.osi.application.OSIApplicationLayerIntroduce}
 */
public interface OSIIntroduce {
}
