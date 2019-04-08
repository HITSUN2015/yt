package com.yt.demo.helper.util.print;/**
 * Created by SUN on 19/4/7.
 */

/**
 * @author SUN
 * @create 2019-04-07 上午10:25
 * @desc
 */
public class LifePointer {

    private String startLifeLineFullPath;

    private String endLifeLineFullPath;

    public LifePointer(String startLifeLineFullPath, String endLifeLineFullPath) {
        this.startLifeLineFullPath = startLifeLineFullPath;
        this.endLifeLineFullPath = endLifeLineFullPath;
    }

    public String getStartLifeLineFullPath() {
        return startLifeLineFullPath;
    }

    public void setStartLifeLineFullPath(String startLifeLineFullPath) {
        this.startLifeLineFullPath = startLifeLineFullPath;
    }

    public String getEndLifeLineFullPath() {
        return endLifeLineFullPath;
    }

    public void setEndLifeLineFullPath(String endLifeLineFullPath) {
        this.endLifeLineFullPath = endLifeLineFullPath;
    }
}
