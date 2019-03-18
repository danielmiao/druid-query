package com.light.druid.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author danielmiao
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@DruidDataSource(name = CouponStatDefine.DATA_SOURCE)
public class CouponStat {
    /**
     * 创建时间戳
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_CREATE_TIMESTAMP)
    @DruidField(name = CouponStatDefine.DIMENSIONS_CREATE_TIMESTAMP)
    private String createTimestamp;
    /**
     * 店铺编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_STORE_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_STORE_ID)
    private long storeId;
    /**
     * 规则编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_RULE_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_RULE_ID)
    private long ruleId;
    /**
     * 失效时间戳
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_DISABLE_TIMESTAMP)
    @DruidField(name = CouponStatDefine.DIMENSIONS_DISABLE_TIMESTAMP)
    private long disableTimestamp;
    /**
     * 发放优惠券编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_DEPLOY_COUPON_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_DEPLOY_COUPON_ID)
    private String dispatchCouponId;
    /**
     * 发放用户编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_DEPLOY_USER_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_DEPLOY_USER_ID)
    private long dispatchUserId;
    /**
     * 发放金额
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_DEPLOY_AMOUNT)
    @DruidField(name = CouponStatDefine.DIMENSIONS_DEPLOY_AMOUNT)
    private long dispatchAmount;
    /**
     * 已使用券编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_USED_COUPON_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_USED_COUPON_ID)
    private String usedCouponId;
    /**
     * 已使用用户编号
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_USED_USER_ID)
    @DruidField(name = CouponStatDefine.DIMENSIONS_USED_USER_ID)
    private long usedUserId;
    /**
     * 发放金额
     */
    @JsonProperty(CouponStatDefine.DIMENSIONS_USED_AMOUNT)
    @DruidField(name = CouponStatDefine.DIMENSIONS_USED_AMOUNT)
    private long usedAmount;

}
