package com.yt.coding.pattern.reactor.reactor1;

/**
 * Created by yantong on 2019/3/6.
 */
public class Test {

    private static final String REDIS_ALARM_VALUEADDED_LIFECYCLE_PREX="RS_ALARM_SERVICE_LIFECYCLE";
    private static final String REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR="_";
    private static final int SERVICE_LIFECYCLE_CACHE_TIME = 3600 * 24 * 1; //默认保存1天

    private static String getLifeCycleRedisKey(String userId,String serverCode){
        StringBuilder sb = new StringBuilder();
        sb.append(REDIS_ALARM_VALUEADDED_LIFECYCLE_PREX).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(userId).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(serverCode);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getLifeCycleRedisKey("user_id", "100002"));

        System.out.println(getLifeCycleRedisKey("2a4718f776864f17a2cffb49c1176449", "831108697", 1, "100001"));
    }

    private static String getLifeCycleRedisKey(String userId,String devId,int channelNo,String serverCode){
        StringBuilder sb = new StringBuilder();
        sb.append(REDIS_ALARM_VALUEADDED_LIFECYCLE_PREX).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(userId).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(devId).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(channelNo).append(REDIS_ALARM_VALUEADDED_LIFECYCLE_CONNECTOR)
                .append(serverCode);
        return sb.toString();
    }
}
