package yt.tool.modal;

/**
 * Created by yantong on 2018/11/21.
 */
public class TestClass {
    protected Long opTime;
    //重试次数
    protected Integer retryTime;
    //重试相关的业务ID 英文逗号分隔
    protected String dataIds;
    //事件类型
    protected String eventEnum;
    //设备序列号
    protected String deviceSerial;
    //增值服务 的 唯一标识 后续添加
    protected String eventId;
    //默认为 false 给 异常情况使用
//    protected transient boolean shouldCancelRedisIfSuccess = false;


    public Long getOpTime() {
        return opTime;
    }

    public void setOpTime(Long opTime) {
        this.opTime = opTime;
    }

    public Integer getRetryTime() {
        return retryTime;
    }

    public void setRetryTime(Integer retryTime) {
        this.retryTime = retryTime;
    }

    public String getDataIds() {
        return dataIds;
    }

    public void setDataIds(String dataIds) {
        this.dataIds = dataIds;
    }

    public String getEventEnum() {
        return eventEnum;
    }

    public void setEventEnum(String eventEnum) {
        this.eventEnum = eventEnum;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "opTime=" + opTime +
                ", retryTime=" + retryTime +
                ", dataIds='" + dataIds + '\'' +
                ", eventEnum='" + eventEnum + '\'' +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", eventId='" + eventId + '\'' +
//                ", shouldCancelRedisIfSuccess=" + shouldCancelRedisIfSuccess +
                '}';
    }

}
