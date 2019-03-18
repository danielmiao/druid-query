package com.light.druid.utils;

public class DruidNumberParser {

    public static long parserLong(String value) {
        int index = value.indexOf(".");
        if (index > 0) {
            value = value.substring(0, index);
            return Long.parseLong(value);
        } else {
            return Long.parseLong(value);
        }
    }

    public static int parserInteger(String value) {
        int index = value.indexOf(".");
        if (index > 0) {
            value = value.substring(0, index);
            return Integer.parseInt(value);
        } else {
            return Integer.parseInt(value);
        }
    }
}
