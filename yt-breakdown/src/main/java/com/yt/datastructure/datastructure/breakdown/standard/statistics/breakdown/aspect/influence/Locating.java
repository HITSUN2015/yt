package com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.influence;

/**
 * Created by yantong on 2019/3/18.
 * 我自己加的 描述 是如何定位的
 *
 * TODO 研发通过GDB工具分析core文件
 */
public class Locating {

    private String businessLog;
    private String monitor;//可以先查看监控（要分服务商，易定位） 流量、连接数 TODO 排除性能影响
    private String topCommand;
    private String jstackTrace;
    private String sourceCode;

    public String getBusinessLog() {
        return businessLog;
    }

    public void setBusinessLog(String businessLog) {
        this.businessLog = businessLog;
    }

    public String getTopCommand() {
        return topCommand;
    }

    public void setTopCommand(String topCommand) {
        this.topCommand = topCommand;
    }

    public String getJstackTrace() {
        return jstackTrace;
    }

    public void setJstackTrace(String jstackTrace) {
        this.jstackTrace = jstackTrace;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
}
