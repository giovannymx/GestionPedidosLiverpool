package com.liverpool.orders.infrastructure.adapter.out.mongo;

import java.util.Optional;

import com.liverpool.orders.domain.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter {

    private final MongoTemplate mongoTemplate;

    public UserRepositoryAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /*
    public Optional<UserDocument> findByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        UserDocument user = mongoTemplate.findOne(query, UserDocument.class);
        return Optional.ofNullable(user);
    } */

    public Optional<User> findByUserId(String userId) {
        // 1. Ver qué base de datos está usando Spring en tiempo de ejecución
        System.out.println(">>> BD ACTUAL EN SPRING: " + mongoTemplate.getDb().getName());

        Query query = new Query(Criteria.where("userId").is(userId));
        UserDocument doc = mongoTemplate.findOne(query, UserDocument.class);

        // 2. Imprimir el documento crudo recuperado
        System.out.println(">>> DOCUMENTO RECUPERADO DE MONGO: " + doc);

        if (doc == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(UserMapper.toDomain(doc));
    }
}
