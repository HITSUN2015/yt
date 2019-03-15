package com.yt.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by yantong on 2019/3/14.
 */
@Test
public class DateUtilTest {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void testPeriod() throws ParseException {
        String startString = "2018-03-21 17:43:43";
        Date start = sdf.parse(startString);

        String endString = "2019-03-22 00:00:01";
        Date end = sdf.parse(endString);
        long days = DateUtil.daysOfDate(start, end);
//        System.out.println(DateUtil.daysOfDate(start, end).getMonths());
        Assert.assertEquals(1, days);
    }

    public void testDuration() throws ParseException {
        String startString = "2018-03-21 17:43:43";
        Date start = sdf.parse(startString);

        String endString = "2018-03-21 17:43:45";
        Date end = sdf.parse(endString);
        long seconds = DateUtil.secondsOfDate(start, end);
        Assert.assertEquals(2, seconds);
    }

    @Test
    public void testDateOf() throws ParseException {
        String endString = "2018-03-21 17:43:45";
        Date end = sdf.parse(endString);
        LocalDate localDate = DateUtil.localDateOf(end);
        Date date = DateUtil.dateOfLocalDate(localDate);
        Assert.assertEquals(sdf.format(date).substring(0,10), endString.substring(0, 10));
        Assert.assertEquals(sdf.format(date).substring(10), " 00:00:00");

        LocalDateTime localDateTime = DateUtil.localDateTimeOf(end);
        Date date2 = DateUtil.dateTimeOfLocalDate(localDateTime);
        Assert.assertEquals(sdf.format(date2), endString);
    }

    /**
     * {@link java.time.OffsetDateTime} 对计算机友好的
     * {@link java.time.ZonedDateTime}  对人更友好
     */
    @Test
    public void testJava8Time() {
        //构造
        LocalDate today = LocalDate.now();
        LocalDate someDay = LocalDate.of(2019, 3, 14);
//        LocalDate totalDayFrom20190101 = LocalDate.ofEpochDay();

        //格式化输出
        //不能添加 yyyy年MM月dd日hh 会报错java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
        System.out.println(today);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(today.format(dtf));

        YearMonth yearMonth = YearMonth.from(someDay);
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfYear());
    }

    @Test
    public void testGetSecondsFromNowToTomorrow() {
        System.out.println(DateUtil.getSecondsFromNowToTomorrow());
    }
}
