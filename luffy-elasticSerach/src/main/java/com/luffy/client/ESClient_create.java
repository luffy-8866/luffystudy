package com.luffy.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/27 16:54
 */
public class ESClient_create {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
        //创建索引
        CreateIndexRequest luffy = new CreateIndexRequest("luffy");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(luffy, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);


        restHighLevelClient.close();

    }
}
