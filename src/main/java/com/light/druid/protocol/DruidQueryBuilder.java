package com.light.druid.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.light.druid.annotation.DruidDataSource;
import com.light.druid.annotation.DruidField;
import com.light.druid.type.DruidFieldType;
import com.light.druid.type.DruidQueryGranularity;
import com.light.druid.type.DruidQueryType;
import com.light.druid.utils.DruidDateConvert;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author danielmiao
 */
public class DruidQueryBuilder {

    @Getter
    private static class DruidFieldCache {
        @Setter
        private String dataSource;
        private List<DruidFieldItem> item = new ArrayList<>();
    }

    @Getter
    @Setter
    private static class DruidFieldItem {
        /**
         * 字段名称,优先级为DruidFiled:Name,JsonProperty:Value,Param:Name
         */
        private String fieldName;

        /**
         * 返回名称,优先级为JsonProperty:Value,Param:Name
         */
        private String jsonProperty;

        /**
         * 字段类型
         */
        private DruidFieldType druidFieldType;
    }

    private static Map<Class<?>, DruidFieldCache> fieldCacheMap = new HashMap<>();


    protected DruidQuery query;

    private static DruidFieldCache processClass(Class<?> target) {
        DruidFieldCache cache = new DruidFieldCache();

        //process DruidDataSource
        DruidDataSource annotation = target.getAnnotation(DruidDataSource.class);
        if (annotation != null) {
            cache.setDataSource(annotation.name());
        }
        if (cache.getDataSource() == null) {
            cache.setDataSource(target.getSimpleName());
        }

        for (Field field : target.getDeclaredFields()) {
            //process DruidField
            DruidFieldItem item = new DruidFieldItem();
            DruidField druidField = field.getAnnotation(DruidField.class);
            if (druidField != null) {
                item.setFieldName(druidField.name());
                item.setDruidFieldType(druidField.type());
            }
            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            if (jsonProperty != null) {
                item.setJsonProperty(jsonProperty.value());
                if (item.getFieldName() == null || item.getFieldName().isEmpty()) {
                    item.setFieldName(jsonProperty.value());
                }
            }
            if (item.getFieldName() == null || item.getFieldName().isEmpty()) {
                item.setFieldName(field.getName());
            }
            if (item.getJsonProperty() == null || item.getJsonProperty().isEmpty()) {
                item.setJsonProperty(field.getName());
            }
            if (item.getDruidFieldType() == null) {
                item.setDruidFieldType(DruidFieldType.DIMENSION);
            }
            cache.getItem().add(item);
        }
        fieldCacheMap.put(target, cache);
        return cache;
    }


    DruidQueryBuilder(DruidQueryType queryType, Class<?> target, Class<?> result) {
        this.query = new DruidQuery();
        this.query.setQueryType(queryType.getValue());
        DruidFieldCache targetCache = fieldCacheMap.get(target);
        if (targetCache == null) {
            targetCache = processClass(target);
        }

        DruidFieldCache resultCache = fieldCacheMap.get(result);
        if (resultCache == null) {
            resultCache = processClass(result);
        }

        this.query.setDataSource(targetCache.dataSource);
        for (DruidFieldItem item : resultCache.getItem()) {
            if (!item.getDruidFieldType().isSupportAggregation()) {
                continue;
            }
            this.query.getAggregations().add(new DruidAggregation(item.getDruidFieldType().getAggregationName(),
                    item.getJsonProperty(), item.getFieldName()));
        }
    }

    /**
     * 设置查询粒度
     */
    public DruidQueryBuilder setGranularity(@Valid @NotNull DruidQueryGranularity queryGranularity) {
        this.query.setGranularity(queryGranularity.getValue());
        return this;
    }

    /**
     * 设置过滤器
     */
    public DruidQueryBuilder setFilter(@Valid @NotNull DruidFilter filter) {
        this.query.setFilter(filter);
        return this;
    }


    /**
     * 设置周期
     */
    public DruidQueryBuilder addInterval(@Valid @Min(0) long start, @Valid @Min(0) long end) {
        this.query.getIntervals().add(DruidDateConvert.convertTimestamp(start) + "/" + DruidDateConvert
                .convertTimestamp(end));
        return this;
    }

    public DruidQuery build() {
        return this.query;
    }
}
