package com.github.conanchen.guoi.graphql.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/5/31 11:07 PM
 */
public class DateTimeUtil {
    public static Date toDate(LocalDate date) {
        Objects.requireNonNull(date, "date");

        return toDate(date.atStartOfDay());
    }

    public static Date toDate(LocalDateTime dateTime) {
        Objects.requireNonNull(dateTime, "dateTime");

        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
