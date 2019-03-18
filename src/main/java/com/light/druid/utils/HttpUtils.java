package com.light.druid.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author danielmiao
 */
@Slf4j
public class HttpUtils {

    private static final Charset CHAR_SET = Charset.forName("UTF-8");

    static {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(200);
        manager.setDefaultMaxPerRoute(200);
        httpclient = HttpClients.custom().setConnectionManager(manager).build();
    }

    private static CloseableHttpClient httpclient;

    private static RequestConfig config = RequestConfig.copy(RequestConfig.DEFAULT).setSocketTimeout(30000)
            .setConnectTimeout(30000).setConnectionRequestTimeout(20000).build();


    public static String post(String url, String json) {
        String ret = "";

        HttpPost post = new HttpPost(url);
        post.setConfig(config);
        post.addHeader(HTTP.CONTENT_TYPE, "application/json");
        post.addHeader(HTTP.CONTENT_ENCODING, "UTF-8");
        long time = System.currentTimeMillis();
        log.info("Request url=[{}], param=[{}].", url, json);
        StringEntity entity = new StringEntity(json, "UTF-8");
        post.setEntity(entity);
        try (CloseableHttpResponse response = httpclient.execute(post)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ret = EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                log.warn("System level error, Code=[{}].", response.getStatusLine().getStatusCode());
            }
        } catch (ClientProtocolException e) {
            log.error("SClientProtocolException, Message=[{}].", e.getMessage());
        } catch (IOException e) {
            log.warn("IOException, Message=[{}].", e.getMessage());
        } finally {
            log.info("Response Time=[{}],Param=[{}].", (System.currentTimeMillis() - time), ret);
        }
        return ret;
    }

}
