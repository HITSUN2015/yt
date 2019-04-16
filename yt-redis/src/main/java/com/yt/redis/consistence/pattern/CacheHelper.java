package com.yt.redis.consistence.pattern;/**
 * Created by SUN on 19/4/11.
 */

/**
 * @author SUN
 * @create 2019-04-11 下午8:16
 * @desc
 */
public class CacheHelper {

    private String cacheValue;

    public String getOK() {
        return cacheValue;
    }

    public String getError(){
        return null;
    }

    public boolean writeOK(String newValue) {
        cacheValue = newValue;
        return true;
    }

    public boolean writeError(String newValue) {
        return false;
    }

}
