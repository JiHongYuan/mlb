package org.github.mlb.search.biz.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @author JiHongYuan
 * @date 2021/9/16 23:42
 */
@Configurable
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.56.102", 9200, "http")));
        return client;
    }

}
