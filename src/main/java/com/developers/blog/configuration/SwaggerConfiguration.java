package com.developers.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	@Profile({ "local", "develop" })
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.developers.blog.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}

	@Bean
	@Profile("production")
	public Docket disable() {
		return new Docket(DocumentationType.SWAGGER_2)
			.enable(false);
	}

	private ApiInfo apiInfo() {

		return new ApiInfo(
			"Developers Blog Web",
			"개발자 블로그 Web",
			"1.0",
			"",
			new Contact("Developers Blog", "", ""),
			"",
			"",
			Collections.emptyList()
		);
	}
}