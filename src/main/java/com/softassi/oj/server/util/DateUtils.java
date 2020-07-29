package com.softassi.oj.server.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName : DateUtils
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-30 00:05
 */
public class DateUtils {
    private static final DateTimeFormatter LOCAL_DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter LOCAL_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate parseDate(String text) {
        return LocalDate.parse(text, LOCAL_DATE);
    }

    public LocalDateTime parseDatetime(String text) {
        return LocalDateTime.parse(text, LOCAL_DATE_TIME);
    }

}


