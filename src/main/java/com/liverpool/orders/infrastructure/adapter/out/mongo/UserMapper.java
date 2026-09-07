package com.liverpool.orders.infrastructure.adapter.out.mongo;

import com.liverpool.orders.domain.model.OrderEmbedded;
import com.liverpool.orders.domain.model.User;

import java.util.Collections;
import java.util.stream.Collectors;

public class UserMapper {

    private UserMapper() {
        // Constructor privado para evitar instanciación de clase de utilidad
    }

    /**
     * Convierte la entidad de infraestructura (Mongo Document) al modelo de dominio.
     */
    public static User toDomain(UserDocument doc) {
        if (doc == null) {
            return null;
        }

        User domainUser = new User();
        domainUser.setUserId(doc.getUserId());
        domainUser.setNombre(doc.getNombre());
        domainUser.setApellidoPaterno(doc.getApellidoPaterno());
        domainUser.setApellidoMaterno(doc.getApellidoMaterno());
        domainUser.setCorreoElectronico(doc.getCorreoElectronico());
        domainUser.setDireccionEnvio(doc.getDireccionEnvio());

        // Mapear la lista de órdenes embebidas con validación de nulos
        if (doc.getOrders() != null && !doc.getOrders().isEmpty()) {
            domainUser.setOrders(doc.getOrders().stream()
                    .map(orderDoc -> new OrderEmbedded(orderDoc.getOrderRef()))
                    .collect(Collectors.toList()));
        } else {
            domainUser.setOrders(Collections.emptyList());
        }

        return domainUser;
    }

    /**
     * Convierte el modelo de dominio a la entidad de infraestructura (Mongo Document).
     */
    public static UserDocument toDocument(User user) {
        if (user == null) {
            return null;
        }

        UserDocument doc = new UserDocument();
        doc.setUserId(user.getUserId());
        doc.setNombre(user.getNombre());
        doc.setApellidoPaterno(user.getApellidoPaterno());
        doc.setApellidoMaterno(user.getApellidoMaterno());
        doc.setCorreoElectronico(user.getCorreoElectronico());
        doc.setDireccionEnvio(user.getDireccionEnvio());

        if (user.getOrders() != null && !user.getOrders().isEmpty()) {
            doc.setOrders(user.getOrders().stream()
                    .map(orderDomain -> new UserDocument.OrderEmbedded(orderDomain.getOrderRef()))
                    .collect(Collectors.toList()));
        } else {
            doc.setOrders(Collections.emptyList());
        }

        return doc;
    }
}