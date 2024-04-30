package com.fatec.springapi4.swagger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

   @Bean
   public OpenAPI defineOpenApi() {
       Server server = new Server();
       server.setUrl("http://localhost:8080");
       server.setDescription("Development");

       Info information = new Info()
               .title("Oracle Spring API")
               .version("1.2")
               .description("This API exposes endpoints to Fatec API 4ºSemester aplication");
       return new OpenAPI().info(information).servers(List.of(server));
   }
}