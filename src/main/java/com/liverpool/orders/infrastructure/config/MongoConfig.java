package com.liverpool.orders.infrastructure.config;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        // Asegura enviar "liverpool_db" como segundo argumento
        return new MongoTemplate(mongoClient, "liverpool_db");
    }
}