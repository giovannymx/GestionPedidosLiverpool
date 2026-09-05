package com.liverpool.orders.infrastructure.adapter.out.mongo;

import com.liverpool.orders.domain.model.Order;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SearchOrderAdapter {

    private final MongoTemplate mongoTemplate;

    public SearchOrderAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<OrderDocument> searchOrdersFlexible(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return mongoTemplate.findAll(OrderDocument.class);
        }

        // Limpiar acentos, comas y espacios extra
        String cleanTerm = cleanText(searchTerm);

        // Regex permisivo: permite caracteres intermedios (fuzzy/flexible match)
        String regexPattern = "." + String.join(".", cleanTerm.split("")) + ".*";

        List<Criteria> criteriaList = new ArrayList<>();

        // Búsqueda en los campos requeridos: orderRef, orderStatus, storeName y displayName
        criteriaList.add(Criteria.where("orderRef").regex(regexPattern, "i"));
        criteriaList.add(Criteria.where("orderStatus").regex(regexPattern, "i"));
        criteriaList.add(Criteria.where("storeName").regex(regexPattern, "i"));
        criteriaList.add(Criteria.where("items.displayName").regex(regexPattern, "i"));

        Query query = new Query(new Criteria().orOperator(criteriaList.toArray(new Criteria[0])));

        return mongoTemplate.find(query, OrderDocument.class);
    }

    private String cleanText(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        // Elimina marcas diacríticas (acentos) y caracteres especiales como comas
        return normalized.replaceAll("\\p{M}", "")
                .replaceAll("[,\\.\\-_]", "")
                .toLowerCase()
                .trim();
    }
}
