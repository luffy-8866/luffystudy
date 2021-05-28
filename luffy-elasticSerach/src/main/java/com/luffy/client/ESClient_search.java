package com.luffy.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luffy.model.User;
import net.minidev.json.JSONUtil;
import org.apache.http.HttpHost;
import org.apache.lucene.util.DocIdSetBuilder;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.AliasMetadata;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author luffy
 * @version 1.0
 * @desc
 * @date 2021/4/27 16:54
 */
public class ESClient_search {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
        //查询索引
//        GetIndexRequest luffy = new GetIndexRequest("luffy");
//        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(luffy, RequestOptions.DEFAULT);
//        System.out.println(getIndexResponse.getAliases());
//        System.out.println(getIndexResponse.getMappings());
//        System.out.println(getIndexResponse.getSettings());
//删除索引
//        DeleteIndexRequest luffy = new DeleteIndexRequest("luffy");
//        AcknowledgedResponse delete = restHighLevelClient.indices().delete(luffy, RequestOptions.DEFAULT);
//        System.out.println(delete.isAcknowledged());

        //插入数据
//        IndexRequest indexRequest = new IndexRequest();
//        indexRequest.index("luffy").id("1002");
//        User user = new User("楚阳", "男", "20");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String userJson = objectMapper.writeValueAsString(user);
//        indexRequest.source(userJson, XContentType.JSON);
//        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
//        DocWriteResponse.Result result = response.getResult();
//        System.out.println(result);

//        //update数据
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.index("luffy").id("1001");
//        updateRequest.doc(XContentType.JSON,"sex","女");
//        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
//        System.out.println(update.getResult());
//
//        //get数据
//        GetRequest getRequest = new GetRequest();
//        getRequest.index("luffy").id("1001");
//        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println(documentFields.getSourceAsString());
//
//        //文档删除
//
//        DeleteRequest deleteRequest = new DeleteRequest();
//        deleteRequest.index("luffy").id("1001");
//        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
//        System.out.println(delete.getResult());


        //批量插入
//        BulkRequest bulkRequest = new BulkRequest();
//        bulkRequest.add(new IndexRequest().index("luffy").id("1001").source(XContentType.JSON,"name","莫轻舞"));
//        bulkRequest.add(new IndexRequest().index("luffy").id("1002").source(XContentType.JSON,"name","雪泪寒"));
//        bulkRequest.add(new IndexRequest().index("luffy").id("1003").source(XContentType.JSON,"name","莫天机"));
//        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
//        System.out.println(bulk.getTook());

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("luffy");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        sea


        restHighLevelClient.close();

    }
}