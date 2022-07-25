package app.storecms.storage.database;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class MongoReactiveConf extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
    @Override
    protected String getDatabaseName() {
        return "store";
    }
}