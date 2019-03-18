package com.light.druid.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.light.druid.protocol.DruidQuery;
import com.light.druid.result.DruidTopQueryResult;
import com.light.druid.service.DruidQueryService;
import com.light.druid.utils.HttpUtils;
import com.light.druid.utils.SerializableUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author danielmiao
 */
@Slf4j
public class DruidQueryServiceImpl implements DruidQueryService {

    private final String druidBaseUrl;

    public DruidQueryServiceImpl(String druidBaseUrl) {
        this.druidBaseUrl = druidBaseUrl;
    }

    @Override
    public <T> List<T> query(DruidQuery query, Class<T> clazz) {
        return this.query(query, SerializableUtils.json.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    @Override
    public <T> List<DruidTopQueryResult<T>> queryTopN(DruidQuery query, Class<T> clazz) {
        TypeFactory factory = SerializableUtils.json.getTypeFactory();
        JavaType nodeType = factory.constructParametricType(DruidTopQueryResult.class, clazz);
        JavaType listType = factory.constructCollectionType(List.class, nodeType);
        return this.query(query, listType);
    }

    private <T> List<T> query(DruidQuery query, JavaType javaType) {
        List<T> result = null;
        try {
            String context = HttpUtils.post(druidBaseUrl, query.toString());
            if (context != null && !context.isEmpty()) {
                result = SerializableUtils.json.readValue(context, javaType);
            }
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException", e);
        } catch (IOException e) {
            log.error("IOException", e);
        }
        return result == null ? new ArrayList<>() : result;
    }
}
