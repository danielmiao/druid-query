package com.light.druid.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.light.druid.type.DruidFieldType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: danielmiao
 * @Date: 2019/3/16 17:43
 * @Version 0.0.1
 */
@Getter
@Setter
@ToString
public class CouponQueryItem {

    @JsonProperty("ruid")
    @DruidField(name = CouponStatDefine.DIMENSIONS_RULE_ID, type = DruidFieldType.DIMENSION)
    private String ruleId;

    @JsonProperty("user")
    @DruidField(name = CouponStatDefine.METRICS_SPEC_HYPER_UNIQUE_DEPLOY_USER_ID, type = DruidFieldType.HYPER_UNIQUE)
    private String deployUser;

    @JsonProperty("amt")
    @DruidField(name = CouponStatDefine.METRICS_SPEC_LONG_SUM_DEPLOY_AMOUNT, type = DruidFieldType.LONG_SUM)
    private long deployAmount;

    @JsonProperty("cop")
    @DruidField(name = CouponStatDefine.METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID, type = DruidFieldType.HYPER_UNIQUE)
    private String deployCoupon;

    @JsonProperty("ucop")
    @DruidField(name = CouponStatDefine.METRICS_SPEC_HYPER_UNIQUE_USED_COUPON_ID, type = DruidFieldType.HYPER_UNIQUE)
    private String userdCoupon;

    @JsonProperty("uamt")
    @DruidField(name = CouponStatDefine.METRICS_SPEC_LONG_SUM_USED_AMOUNT, type = DruidFieldType.LONG_SUM)
    private long usedAmount;
}
