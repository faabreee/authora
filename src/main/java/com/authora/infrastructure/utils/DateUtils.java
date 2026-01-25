package com.authora.infrastructure.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static Date convertStringToDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd]");

        LocalDate localDate = LocalDate.parse(dateStr, formatter);

        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
