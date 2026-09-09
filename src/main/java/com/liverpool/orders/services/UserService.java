package com.liverpool.orders.services;

import com.liverpool.orders.domain.model.OrderEmbedded;
import com.liverpool.orders.domain.model.User;
import com.liverpool.orders.domain.port.UserRepositoryPort;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.ExternalApiClient;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderMockDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoryPort userRepository;
    private final ExternalApiClient externalApiClient;

    public UserService(UserRepositoryPort userRepository, ExternalApiClient externalApiClient) {
        this.userRepository = userRepository;
        this.externalApiClient = externalApiClient;
    }

    public User createUser(User user) {
        user.setOrders(fetchOrdersForUser(user.getUserId()));
        return userRepository.save(user);
    }

    public User getUserWithOrders(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con userId: " + userId));

        List<OrderEmbedded> externalOrders = fetchOrdersForUser(userId);
        if (!externalOrders.isEmpty()) {
            user.setOrders(externalOrders);
            return userRepository.save(user);
        }
        return user;
    }

    public User updateUser(String userId, User updatedUserData) {
        User existingUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con userId: " + userId));

        existingUser.setNombre(updatedUserData.getNombre());
        existingUser.setApellidoPaterno(updatedUserData.getApellidoPaterno());
        existingUser.setApellidoMaterno(updatedUserData.getApellidoMaterno());
        existingUser.setCorreoElectronico(updatedUserData.getCorreoElectronico());
        existingUser.setDireccionEnvio(updatedUserData.getDireccionEnvio());
        existingUser.setOrders(fetchOrdersForUser(userId));

        return userRepository.save(existingUser);
    }

    private List<OrderEmbedded> fetchOrdersForUser(String userId) {
        if (userId == null || userId.isBlank()) return Collections.emptyList();
        try {
            List<OrderMockDto> pedidos = externalApiClient.fetchPedidos();
            return pedidos.stream()
                    .filter(p -> userId.equals(p.getUserId()))
                    .map(p -> new OrderEmbedded(p.getOrderRef()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}