package com.light.druid.annotation;

import java.time.*;

/**
 * The type Druid date convert.
 */
public class StatisticsDateConvert {

    private final static ZoneId ZONE = ZoneId.systemDefault();
    private final static ZoneOffset OFFSET = OffsetDateTime.now().getOffset();

    /**
     * Gets min of day.
     *
     * @param timestamp the timestamp
     * @return the min of day
     */
    public static long getMinOfMouth(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        LocalDate date = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth(), 1);
        return LocalDateTime.of(date, LocalTime.MIN).toInstant(OFFSET)
                .toEpochMilli();
    }

    /**
     * Gets min of day.
     *
     * @param timestamp the timestamp
     * @return the min of day
     */
    public static long getMaxOfMouth(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        LocalDate date = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getMonth()
                .length(localDateTime.getYear() % 4 == 0));
        return LocalDateTime.of(date, LocalTime.MIN).toInstant(OFFSET)
                .toEpochMilli();
    }

    /**
     * Gets min of day.
     *
     * @param timestamp the timestamp
     * @return the min of day
     */
    public static long getMinOfDay(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        return LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).toInstant(OFFSET)
                .toEpochMilli();
    }

    /**
     * Gets max of day.
     *
     * @param timestamp the timestamp
     * @return the max of day
     */
    public static long getMaxOfDay(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        return LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).toInstant(OFFSET)
                .toEpochMilli();
    }

    /**
     * Convert to yyyyMMdd int.
     *
     * @param timestamp the timestamp
     * @return the int
     */
    public static int convertToyyyyMMdd(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        return localDateTime.getYear() * 10000 + localDateTime.getMonthValue() * 100 + localDateTime.getDayOfMonth();
    }

    /**
     * Convert to yyyyMM int.
     *
     * @param timestamp the timestamp
     * @return the int
     */
    public static int convertToyyyyMM(long timestamp) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE);
        return convertToyyyyMM(localDateTime.toLocalDate());
    }

    /**
     * Convert to yyyyMM int.
     *
     * @param localDate the local date
     * @return the int
     */
    public static int convertToyyyyMM(LocalDate localDate) {
        return localDate.getYear() * 100 + localDate.getMonthValue();
    }
}
