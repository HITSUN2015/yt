package com.yt.breakdown.standard.statistics.breakdown.aspect.solve;

/**
 * Created by yantong on 2019/3/18.
 */
public class Reason {

    private String reason;

    private Reason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static Reason build(String reson) {
        return new Reason(reson);
    }
}
