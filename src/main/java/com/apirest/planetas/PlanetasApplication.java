package com.apirest.planetas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Bárbara Castro
 */
@SpringBootApplication
public class PlanetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetasApplication.class, args);
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder){
		return builder.baseUrl("https://swapi.dev/api/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

}
