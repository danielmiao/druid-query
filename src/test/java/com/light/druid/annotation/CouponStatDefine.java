package com.light.druid.annotation;

/**
 * @Author: danielmiao
 * @Date: 2019/2/19 12:02
 * @Version 0.0.1
 */
public class CouponStatDefine {
    public final static String DATA_SOURCE = "coupon_stat";

    /**
     * 创建时间戳
     */
    public final static String DIMENSIONS_CREATE_TIMESTAMP = "tsct";
    /**
     * 店铺编号
     */
    public final static String DIMENSIONS_STORE_ID = "stid";
    /**
     * 券规则编号
     */
    public final static String DIMENSIONS_RULE_ID = "ruid";
    /**
     * 过期时间戳
     */
    public final static String DIMENSIONS_DISABLE_TIMESTAMP = "tsde";
    /**
     * 发放券编号
     */
    public final static String DIMENSIONS_DEPLOY_COUPON_ID = "dcpid";
    /**
     * 发放用户编号
     */
    public final static String DIMENSIONS_DEPLOY_USER_ID = "duid";
    /**
     * 发放券金额
     */
    public final static String DIMENSIONS_DEPLOY_AMOUNT = "damt";
    /**
     * 使用券编号
     */
    public final static String DIMENSIONS_USED_COUPON_ID = "ucpid";
    /**
     * 使用用户编号
     */
    public final static String DIMENSIONS_USED_USER_ID = "uuid";
    /**
     * 使用券金额
     */
    public final static String DIMENSIONS_USED_AMOUNT = "uamt";

    /**
     * 发放券金额计数
     */
    public final static String METRICS_SPEC_LONG_SUM_DEPLOY_AMOUNT = "smdam";
    /**
     * 使用券金额计数
     */
    public final static String METRICS_SPEC_LONG_SUM_USED_AMOUNT = "smuam";
    /**
     * 发放用户计数
     */
    public final static String METRICS_SPEC_HYPER_UNIQUE_DEPLOY_USER_ID = "hudu";
    /**
     * 发放券数量计数
     */
    public final static String METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID = "hudcp";
    /**
     * 使用券数量计数
     */
    public final static String METRICS_SPEC_HYPER_UNIQUE_USED_COUPON_ID = "huucp";
}
