package com.light.druid.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * The type Serializable utils.
 */
public class SerializableUtils {
    /**
     * The constant json.
     */
    public final static ObjectMapper json = new ObjectMapper();

    /**
     * The constant base64_decode.
     */
    public final static Decoder base64_decode = Base64.getDecoder();

    /**
     * The constant base64_encode.
     */
    public final static Encoder base64_encode = Base64.getEncoder();

    /**
     * The constant base64_url_decode.
     */
    public final static Decoder base64_url_decode = Base64.getUrlDecoder();

    /**
     * The constant base64_url_encode.
     */
    public final static Encoder base64_url_encode = Base64.getUrlEncoder();

    static {
        json.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 随机字符串
     */
    private static final String SOURCE = "0123456789ABCDEFGHJKLMNPQRSTUWXY";

    /**
     * 线程本地StringBuilder
     */
    private final static ThreadLocal<StringBuilder> threadSafeStringBuilder = ThreadLocal.withInitial(() -> new
            StringBuilder(1024));

    /**
     * To hex string string.
     *
     * @param bytes the bytes
     * @return string
     */
    public final static String toHexString(byte[] bytes) {
        StringBuilder builder = threadSafeStringBuilder.get();
        builder.delete(0, builder.capacity());
        for (byte b : bytes) {
            int v = b & 0xff;
            builder.append(SOURCE.charAt((v >>> 4)));
            builder.append(SOURCE.charAt((v & 0xF)));
        }
        return builder.toString();
    }


    /**
     * Decode hex string byte [ ].
     *
     * @param str the str
     * @return the byte [ ]
     */
    public final static byte[] decodeHexString(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        byte[] buffer = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            buffer[i / 2] = (byte) (CharUtils.convertLetterToNum(chars[i]) << 4 | CharUtils.convertLetterToNum
                    (chars[i + 1]));
        }
        return buffer;
    }
}
