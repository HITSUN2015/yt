package com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.solve;

/**
 * Created by yantong on 2019/3/18.
 */
public class Action {

    private String action;

    private Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static Action build(String action) {
        return new Action(action);
    }
}
