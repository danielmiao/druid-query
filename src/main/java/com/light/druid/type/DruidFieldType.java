package com.light.druid.type;

/**
 * The enum Druid aggregationName type.
 *
 * @author danielmiao
 */
public enum DruidFieldType {

    /**
     * 维度
     */
    DIMENSION(true, false, ""),
    /**
     * 计数
     */
    COUNT(true, true, "count"),
    /**
     * Long 总和
     */
    LONG_SUM(true, true, "longSum"),
    /**
     * Double 总和
     */
    DOUBLE_SUM(true, true, "doubleSum"),
    /**
     * Float总和
     */
    FLOAT_SUM(true, true, "floatSum"),

    /**
     * Double最小值
     */
    DOUBLE_MIN(true, true, "doubleMin"),
    /**
     * Double最大值
     */
    DOUBLE_MAX(true, true, "doubleMax"),
    /**
     * Float 最小值
     */
    FLOAT_MIN(true, true, "floatMin"),
    /**
     * Float 最大值
     */
    FLOAT_MAX(true, true, "floatMax"),
    /**
     * Long 最小值
     */
    LONG_MIN(true, true, "longMin"),
    /**
     * Long 最大值
     */
    LONG_MAX(true, true, "longMax"),

    /**
     * Double first
     */
    DOUBLE_FIRST(false, true, "doubleFirst"),
    /**
     * Double last druid aggregationName type.
     */
    DOUBLE_LAST(false, true, "doubleLast"),
    /**
     * Float first druid aggregationName type.
     */
    FLOAT_FIRST(false, true, "floatFirst"),
    /**
     * Float last druid aggregationName type.
     */
    FLOAT_LAST(false, true, "floatLast"),
    /**
     * Long first druid aggregationName type.
     */
    LONG_FIRST(false, true, "longFirst"),
    /**
     * Long last druid aggregationName type.
     */
    LONG_LAST(false, true, "longLast"),

    /**
     * 汇聚
     */
    HYPER_UNIQUE(true, true, "hyperUnique");

    /**
     * 摄入阶段支持
     */
    private boolean supportIngestion;
    /**
     * 聚合阶段支持
     */
    private boolean supportAggregation;
    /**
     * 聚合名称
     */
    private String aggregationName;

    DruidFieldType(boolean supportIngestion, boolean supportAggregation, String aggregationName) {
        this.supportIngestion = supportIngestion;
        this.supportAggregation = supportAggregation;
        this.aggregationName = aggregationName;
    }

    /**
     * Is support ingestion boolean.
     *
     * @return the boolean
     */
    public boolean isSupportIngestion() {
        return supportIngestion;
    }

    /**
     * Is support aggregation boolean.
     *
     * @return the boolean
     */
    public boolean isSupportAggregation() {
        return supportAggregation;
    }

    /**
     * Gets aggregation name.
     *
     * @return the aggregation name
     */
    public String getAggregationName() {
        return aggregationName;
    }
}
