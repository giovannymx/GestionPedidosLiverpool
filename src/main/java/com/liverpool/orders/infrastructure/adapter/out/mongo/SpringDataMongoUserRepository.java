package com.liverpool.orders.infrastructure.adapter.out.mongo;

import java.util.Optional;

import com.liverpool.orders.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<UserDocument, String> {
    // Debe coincidir exactamente con el nombre de la variable "userId" en UserDocument
    @Query("{ 'userId' : ?0 }")
    Optional<UserDocument> findByUserId(String userId);
    void deleteByUserId(String userId);

    User save(User user);
}