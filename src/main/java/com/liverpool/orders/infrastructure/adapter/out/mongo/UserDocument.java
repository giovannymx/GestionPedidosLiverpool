package com.liverpool.orders.infrastructure.adapter.out.mongo;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class UserDocument {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field("userId")
    private String userId;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String direccionEnvio;
    private List<OrderEmbedded> orders;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getDireccionEnvio() { return direccionEnvio; }
    public void setDireccionEnvio(String direccionEnvio) { this.direccionEnvio = direccionEnvio; }
    public List<OrderEmbedded> getOrders() { return orders; }
    public void setOrders(List<OrderEmbedded> orders) { this.orders = orders; }

    public static class OrderEmbedded {
        @Field("orderRef")
        private String orderRef;

        public OrderEmbedded() {}
        public OrderEmbedded(String orderRef) { this.orderRef = orderRef; }
        public String getOrderRef() { return orderRef; }
        public void setOrderRef(String orderRef) { this.orderRef = orderRef; }
    }
}