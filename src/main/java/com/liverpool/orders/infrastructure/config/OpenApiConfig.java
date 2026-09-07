package com.liverpool.orders.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Liverpool :: Examen técnico Backend")
                        .version("1.0.0")
                        .description("Aplicación que cumple con las siguientes 2 Actividades: " +
                                "** 1 ** API REST que permite la creación, consulta y actualización de datos de usuario (clientes). " +
                                "Usa una base de datos MongoDB para persistir la información de los usuarios." +
                                "Los usuarios deberán estar identificados mediante un userId que deberá estar vinculado con el campo " +
                                "userId presente en la respuesta del servicio /pedidos. Actualiza la información de los usuarios " +
                                "agregando un nuevo campo llamado “orders”, " +
                                "el cual mostrará los pedidos asociados al usuario, el número de pedido está representado por el campo “orderRef” " +
                                "de la respuesta del servicio /pedidos " +
                                "** 2 ** un servicio de búsqueda con la capacidad de filtrar pedidos mediante los campos “orderRef”, “orderStatus” " +
                                "y “storeName” . Así mismo se deben poder recuperar los productos (items) de cada pedido a través del campo " +
                                "“displayName” incluido en la respuesta del servicio /items. La consulta debe ser por texto (type ahead) " +
                                "y debe ser flexible, es decir, no considerar comas, acentos, mayúsculas o errores mínimos de ortografía.")
                        .contact(new Contact()
                                .name("Giovanny Quevedo")
                                .email("giovanny_mex@hotmail.com")));
    }
}
