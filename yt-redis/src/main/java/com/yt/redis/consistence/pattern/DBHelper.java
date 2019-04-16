package com.yt.redis.consistence.pattern;/**
 * Created by SUN on 19/4/11.
 */

/**
 * @author SUN
 * @create 2019-04-11 下午8:17
 * @desc
 */
public class DBHelper {
    private String dbValue;

    public String getOK() {
        return dbValue;
    }

    public String getError(){
        return null;
    }

    public boolean writeOK(String newValue) {
        dbValue = newValue;
        return true;
    }

    public boolean writeError(String newValue) {
        return false;
    }
}
