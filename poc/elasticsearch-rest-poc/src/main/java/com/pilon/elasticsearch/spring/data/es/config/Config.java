package com.pilon.elasticsearch.spring.data.es.config;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
// import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.pilon.elasticsearch.spring.data.es.repository")
@ComponentScan(basePackages = { "com.pilon.elasticsearch.spring.data.es.service" })
public class Config {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/6.2.2}")
    private String elasticsearchHome;

    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;

    @Value("${elasticsearch.cluster.host:localhost}")
    private String clusterHost;

    @Value("${elasticsearch.cluster.nodePort:9300}")
    private int clusterNodePort;

    @Bean
    public Client client() {
        TransportClient client = null;
        try {
            final Settings elasticsearchSettings = Settings.builder()
            //   .put("client.transport.sniff", true)
              .put("path.home", elasticsearchHome)
              .put("cluster.name", clusterName).build();
            client = new PreBuiltTransportClient(elasticsearchSettings);
            TransportAddress transportAddress = new TransportAddress(Inet4Address.getByName(clusterHost), clusterNodePort);
            client.addTransportAddress(transportAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    // @Bean
    // public ElasticsearchOperations elasticsearchTemplate() {
    //     return new ElasticsearchTemplate(client());
    // }
}
