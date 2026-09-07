package com.liverpool.orders.domain.port;

import com.liverpool.orders.domain.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByUserId(String userId);
}