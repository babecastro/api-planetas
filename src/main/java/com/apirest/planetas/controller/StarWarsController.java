package com.apirest.planetas.controller;

import com.apirest.planetas.models.PlanetaStarWars;
import com.apirest.planetas.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StarWarsController {

    @Autowired
    private WebClient webClient;

    public PlanetaStarWars getPlaneta(Integer id) {
        Mono<PlanetaStarWars> planeta = this.webClient.method(HttpMethod.GET)
                .uri("planets/{id}/", id)
                .retrieve()
                .bodyToMono(PlanetaStarWars.class);

        PlanetaStarWars planeta1 = planeta.block();
        planeta1.toString();
        return planeta1;
    }
}
