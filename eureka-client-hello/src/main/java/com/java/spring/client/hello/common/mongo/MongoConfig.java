package com.java.spring.client.hello.common.mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author renqingwang on 2017/9/6.
 * @version 1.0
 */
@Configuration
@EnableMongoRepositories("com.java.spring.client.hello.repository")
@ConfigurationProperties(prefix = "mongo")
public class MongoConfig extends AbstractMongoConfiguration {
    private String host;
    private Integer port;
    private String db;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    @Override
    protected String getDatabaseName() {
        return db;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }
}
