package com.yt.util;

import java.time.*;
import java.util.Date;

/**
 * Created by yantong on 2019/3/14.
 *
 * 这里强调了对java8的使用
 *
 * 取代Joda
 *
 * java8 相关类的介绍：
 * {@link java.time.Instant}        瞬时
 * {@link java.time.Period}         年月日之间的距离
 * {@link java.time.Duration}       时分秒之间的距离
 * {@link java.time.LocalDate}      年月日
 * {@link java.time.LocalTime}      时分秒
 * {@link java.time.LocalDateTime}  年月日 时分秒
 *
 * java.time包下还是有挺多类的。。。可能需要自己挨个看看 TODO
 * 我将一些功能的演示里 放到了test方法里，而没放在这个类里，这种方法应该是大家习惯使用的
 */
public class DateUtil {

    private static final ZoneId LOCAL_ZONE_ID = ZoneId.systemDefault();

    public static LocalDate localDateOf(Date source) {
        if (null != source) {
            return source.toInstant().atZone(LOCAL_ZONE_ID).toLocalDate();
        }
        return LocalDate.now(LOCAL_ZONE_ID);
    }

    public static LocalDateTime localDateTimeOf(Date source) {
        if (null != source) {
            return source.toInstant().atZone(LOCAL_ZONE_ID).toLocalDateTime();
        }
        return LocalDateTime.now(LOCAL_ZONE_ID);
    }

    public static Date dateOfLocalDate(LocalDate source) {
        // TODO: 2019/3/14 这个方法 有点怪
        ZonedDateTime zdt = source.atStartOfDay(LOCAL_ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    public static Date dateTimeOfLocalDate(LocalDateTime source) {
        ZonedDateTime zdt = source.atZone(LOCAL_ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * 返回两个时间日期的距离
     * @param startTime
     * @param endTime
     * @return
     */
    public static Period periodOfDate(Date startTime, Date endTime) {
        LocalDate startLocalDate = localDateOf(startTime);
        LocalDate endLocalDate = localDateOf(endTime);
        Period period = Period.between(startLocalDate, endLocalDate);
        return period;
    }

    public static Duration durationOfDate(Date startTime, Date endTime) {
        LocalDateTime startLocalDateTime = localDateTimeOf(startTime);
        LocalDateTime endLocalDateTime = localDateTimeOf(endTime);
        Duration duration = Duration.between(startLocalDateTime, endLocalDateTime);
        return duration;
    }

    public static long getSecondsFromNowToTomorrow() {
        LocalDateTime now = LocalDateTime.ofInstant(Instant.now(), LOCAL_ZONE_ID);
        LocalDateTime midnight = now.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Duration duration = Duration.between(now, midnight);
        return duration.getSeconds();
    }

}
