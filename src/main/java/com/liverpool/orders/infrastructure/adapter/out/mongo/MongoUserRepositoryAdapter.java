package com.liverpool.orders.infrastructure.adapter.out.mongo;

import com.liverpool.orders.domain.model.User;
import com.liverpool.orders.domain.port.UserRepositoryPort;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MongoUserRepositoryAdapter implements UserRepositoryPort {

    private final MongoTemplate mongoTemplate;

    public MongoUserRepositoryAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public User save(User user) {
        UserDocument doc = UserMapper.toDocument(user);

        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        UserDocument existing = mongoTemplate.findOne(query, UserDocument.class);
        if (existing != null) {
            doc.setId(existing.getId());
        }

        UserDocument saved = mongoTemplate.save(doc);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        UserDocument doc = mongoTemplate.findOne(query, UserDocument.class);
        return Optional.ofNullable(UserMapper.toDomain(doc));
    }
}
