package com.apirest.planetas.components;

import com.apirest.planetas.models.PlanetaStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Bárbara Castro
 */
@Component
public class StarWarsComponent {

    @Autowired
    private WebClient webClient;

    /**
     * @param id
     * @return planeta da api do Star Wars.
     */
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
