package com.apirest.planetas.resources;

import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.models.PlanetaStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class StarWarsResource {

    @Autowired
    private WebClient webClient;

    public Planeta getPlaneta(Integer id) {
        Mono<PlanetaStarWars> planeta = this.webClient
                .method(HttpMethod.GET)
                .uri("/planets/{id}/", id)
                .retrieve()
                .bodyToMono(PlanetaStarWars.class);

        PlanetaStarWars planeta1 = planeta.block();
        Planeta planeta2 = new Planeta(planeta1.getId(), planeta1.getName(), planeta1.getClimate(), planeta1.getTerrain(), planeta1.getFilms().size());
        planeta1.toString();
        System.out.println("Retorno da api planetas" +planeta1.getFilms().size());
        return planeta2;
    }
}
