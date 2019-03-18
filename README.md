# Druid-Query

druid-query is a simple tools for building a druid json queries.
Timeseries and TopN are supported, followed by Group.

## Usage

### Requisites
 * Java, Maven

### Build
The following steps need to be followed in order to build the jar file :
 * Clone the project on GitHub
 * Do a maven build at the top level of the project using `mvn clean install`
 * jar file will be available under druid-query/target/druid-query*.jar

### Running test cases
 * In order to run test cases use `mvn clean test`

### Maven dependency
Following maven dependency needs to be added in pom.xml project file (if it is available in maven repo) :

    <dependency>
        <groupId>com.danielmiao</groupId>
        <artifactId>druid-query</artifactId>
        <version>1.0.0</version>
        <scope>compile</scope>
    </dependency>
    
## Example

### Simple Query

        DruidQuery query = DruidQuerySimpleBuilder.create()
                .setQueryType(DruidQueryType.TIMESERIES)
                .setDataSource(CouponStatDefine.DATA_SOURCE)
                .setGranularity(DruidQueryGranularity.ALL)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID, Long
                                .toString(storeId))
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_RULE_ID, Long
                                .toString(ruleId))
                        .build())
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_DEPLOY_USER, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_USER_ID)
                .addAggregation(DruidFieldType.LONG_SUM, LOCAL_DEPLOY_AMOUNT, CouponStatDefine
                        .METRICS_SPEC_LONG_SUM_DEPLOY_AMOUNT)
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_DEPLOY_COUPON, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID)
                .addAggregation(DruidFieldType.LONG_SUM, LOCAL_USED_AMOUNT, CouponStatDefine
                        .METRICS_SPEC_LONG_SUM_USED_AMOUNT)
                .addAggregation(DruidFieldType.HYPER_UNIQUE, LOCAL_USED_COUPON, CouponStatDefine
                        .METRICS_SPEC_HYPER_UNIQUE_DEPLOY_COUPON_ID)
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();


### Advance Query

#### Raw Data Bean

    @DruidDataSource(name = CouponStatDefine.DATA_SOURCE)
    public class CouponStat {
        /**
        * 创建时间戳
        */
        @JsonProperty(CouponStatDefine.DIMENSIONS_CREATE_TIMESTAMP)
        @DruidField(name = CouponStatDefine.DIMENSIONS_CREATE_TIMESTAMP)
        private String createTimestamp;
        
        ...

    }
    
#### Result Bean

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
        
        ...
    }
    
#### Timeseries Query

        DruidQuery query = DruidTimeseriesQueryBuilder.create(CouponStat.class, CouponQueryItem.class)
                .setGranularity(DruidQueryGranularity.DAY)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID,
                                Long.toString(storeId))
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_RULE_ID, Long.toString(ruleId))
                        .build())
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();     

#### TopN Query

        DruidQuery query = DruidTopQueryBuilder.create(CouponStat.class, CouponQueryItem.class)
                .setRequiredParam(CouponStatDefine.DIMENSIONS_RULE_ID, 100, LOCAL_DEPLOY_AMOUNT,
                        DruidFilterOrdering.NUMERIC)
                .setGranularity(DruidQueryGranularity.DAY)
                .setFilter(DruidFilterBuilder.create()
                        .setFilter(DruidFilterType.AND)
                        .addFilter(DruidFilterType.SELECTOR, CouponStatDefine.DIMENSIONS_STORE_ID,
                                Long.toString(storeId)).build())
                .addInterval(StatisticsDateConvert.getMinOfDay(timestamp), StatisticsDateConvert.getMaxOfDay
                        (timestamp)).build();

        System.out.println(query.toString());
