package com.yt.intelligence.pieces;

import java.io.Serializable;

/**
 * Created by yantong on 2019/1/8.
 * 通用类：返回结果
 */
public class CommonResponse implements Serializable{

    //业务ID
    private String businessId;

    /**
     * 操作结果状态 {@link CommonStatus}
     */
    private int resultStatus;

    /**
     * 失败信息编码，与businessId组合 查询文档 获取失败原因 {@link TODO}
     */
    private int resultCode;

    //具体业务 附加的返回信息
    private String businessContent;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getBusinessContent() {
        return businessContent;
    }

    public void setBusinessContent(String businessContent) {
        this.businessContent = businessContent;
    }
}
