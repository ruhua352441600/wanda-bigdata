package org.wanda.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EsClientAction {
    private RestHighLevelClient client;
    @Before
    public void before() {
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost",9200,"http")
                )
        );
    }

    @Test  //插入文档
    public void add() {
        System.out.println(client);
        IndexRequest request =  new IndexRequest("heinao");
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("productName","ipod6");
        jsonMap.put("productPrice", 1999);
        jsonMap.put("productType", 0);
        jsonMap.put("productDesc", "8成新");
        request.source(jsonMap);
        IndexResponse indexResponse = null;
        try {
            indexResponse =client.index(request, RequestOptions.DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
    }
    //@Test  //更新文档
    public void update(){
        UpdateRequest request =  new UpdateRequest("heinao", "Vi7Hl3IBAEhniukmgDu7");
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("productName","ipad7");
        jsonMap.put("productPrice", 1999);
        jsonMap.put("productType", 0);
        jsonMap.put("productDesc", "8成新");
        request.doc(jsonMap);
        UpdateResponse updateResponse = null;
        try {
            updateResponse = client.update(request, RequestOptions.DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(updateResponse.status());
    }

    //@Test  //文档是否存在
    public void  isExistDoc(){
        GetRequest request = new GetRequest("heinao", "Vi7Hl3IBAEhniukmgDu7");
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");
        try {
            boolean exists = client.exists(request, RequestOptions.DEFAULT);
            System.out.println("是否存在的结果为：" + exists);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //@Test  //删除文档
    public void  delete() throws IOException {
        DeleteRequest request =  new DeleteRequest("heinao", "Vi7Hl3IBAEhniukmgDu7");
        request.timeout("2s");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }
    //@Test
    public void searchAll() throws IOException {
        SearchRequest request = new SearchRequest("heinao");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(matchAllQueryBuilder).timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println("+++++++++++++++++++++++++++++++");
        for(SearchHit documentFields : response.getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }
    //@Test
    public void search() throws IOException {
        SearchRequest request = new SearchRequest("heinao");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(2);

        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("productName", "ipad7");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(matchQueryBuilder);
        sourceBuilder.query(boolQueryBuilder).timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println("结果总数：" + response.getHits().getTotalHits());
        System.out.println("+++++++++++++++++++++++++++++++");
        SearchHit[] sh = response.getHits().getHits();
        for(int i = 0; i< sh.length;i++) {
            Map<String, Object> hit = sh[i].getSourceAsMap();
            for(String key : hit.keySet()) {
                System.out.print(key + "=" +hit.get(key) + ",");
            }
            System.out.println();
        }
    }

    @After
    public void after() throws IOException {
        client.close();
    }
}
