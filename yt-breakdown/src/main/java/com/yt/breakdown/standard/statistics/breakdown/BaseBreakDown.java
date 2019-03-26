package com.yt.breakdown.standard.statistics.breakdown;


import com.yt.breakdown.standard.statistics.breakdown.aspect.influence.*;
import com.yt.breakdown.standard.statistics.breakdown.aspect.solve.*;
import com.yt.datastructure.breakdown.standard.statistics.breakdown.aspect.influence.*;
import com.yt.datastructure.breakdown.standard.statistics.breakdown.aspect.solve.*;
import com.yt.breakdown.standard.statistics.breakdown.aspect.status.Result;
import com.yt.breakdown.standard.statistics.breakdown.aspect.status.Status;
import com.yt.breakdown.standard.statistics.breakdown.aspect.status.Time;
import com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.influence.*;
import com.yt.datastructure.datastructure.breakdown.standard.statistics.breakdown.aspect.solve.*;

/**
 * Created by yantong on 2019/3/18.
 */
public class BaseBreakDown {
    protected Discovery discovery;
    protected Cause cause;
    protected Reason reason;
    protected Locating locating;
    protected Action action;
    protected Owner owner;

    protected Duration duration;
    protected Region region;
    protected Level level;
    protected Business business;

    protected Result result;
    protected Status status;
    protected Time time;

    public BaseBreakDown() {
    }

    public BaseBreakDown(Reason reason, Locating locating , Action action) {
        this.reason = reason;
        this.locating = locating;
        this.action = action;
    }
}
