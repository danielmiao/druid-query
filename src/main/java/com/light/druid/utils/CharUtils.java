package com.light.druid.utils;

/**
 * Created by danielmiao on 2017/5/24.
 * Version: 1.0.0
 */
public class CharUtils {


    /**
     * Convert Letter to num int.
     * support HEX and BASE32
     *
     * @param ch the ch
     * @return the int
     */
    public static int convertLetterToNum(char ch) {
        int index;
        if (ch > 110) {
            //skip o
            index = ch - 89;
        } else if (ch > 104) {
            //skip i
            index = ch - 88;
        } else if (ch > 96) {
            //low case
            index = ch - 87;
        } else if (ch > 86) {
            index = ch - 58;
        } else if (ch > 79) {
            //skip O
            index = ch - 57;
        } else if (ch > 73) {
            //skip I
            index = ch - 56;
        } else if (ch > 57) {
            //up case
            index = ch - 55;
        } else {
            //number
            index = ch - 48;
        }
        return index;
    }
}
