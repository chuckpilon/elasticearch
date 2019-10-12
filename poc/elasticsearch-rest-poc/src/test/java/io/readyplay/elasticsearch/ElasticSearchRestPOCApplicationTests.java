package com.pilon.elasticsearch;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONObject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.common.transport.TransportAddress;

import static org.junit.Assert.fail;

import java.net.UnknownHostException;
import java.net.Inet4Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchRestPOCApplicationTests {

    private PreBuiltTransportClient client = null;

    @Before
    public void setUp() throws UnknownHostException {

        try {
            Settings settings = Settings.builder()
                .put("cluster.name", "docker-cluster")
                .build();
            client = new PreBuiltTransportClient(settings);
            TransportAddress transportAddress = new TransportAddress(Inet4Address.getByName("localhost"), 9300);
            client.addTransportAddress(transportAddress);
        } catch (Exception e) {
            client.close();
        }
    }

	@Test
	public void givenSearchParameters_thenReturnResults() {
		try {
            SearchResponse response = client
                .prepareSearch("camp")
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                // .setFetchSource(new String[]{"activity"}, null)
                .setFetchSource(true)
                // .setQuery(QueryBuilders.matchAllQuery())
                .setQuery(QueryBuilders.termsQuery("location", "55109"))
                .setExplain(true)
                .execute()
                .actionGet();

            System.out.println("TOTAL HITS: " + response.getHits().getTotalHits());
            JSONObject responseJSON = new JSONObject(response.toString());
            System.out.println(responseJSON);

		} catch (Exception e) {
			fail(e.getLocalizedMessage());
		}
	}

}
