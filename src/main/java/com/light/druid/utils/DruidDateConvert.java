package com.light.druid.utils;

import java.time.*;

/**
 * The type Druid date convert.
 */
public class DruidDateConvert {

    private final static ZoneId ZONE = ZoneId.systemDefault();
    private final static ZoneOffset OFFSET = OffsetDateTime.now().getOffset();

    /**
     * Convert timestamp string.
     *
     * @param timestamp the timestamp
     * @return the string
     */
    public static String convertTimestamp(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        return localDateTime.toString() + "+0800";
    }

    /**
     * Convert from utc long.
     *
     * @param utcTime the utc time
     * @return the long
     */
    public static long convertFromUTC(String utcTime) {
        return Instant.parse(utcTime).toEpochMilli();
    }

}
