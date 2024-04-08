package com.fatec.springapi4.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Collections;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket retornaSwagger() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.virandoprogramador"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(informacoesApi());
	}
	
	private ApiInfo informacoesApi() {
		return new ApiInfo("Plataforma Khali",
				"Gerenciamento de parceiros",
				"V1", "Api - Livre",
				new Contact("Equipe Khali", " ", " "),
				null, null, Collections.emptyList());
	}
}
