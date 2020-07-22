package com.apirest.planetas.repository;

import com.apirest.planetas.models.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Bárbara Castro
 */
@Repository
public interface PlanetaRepository extends MongoRepository <Planeta, String> {

    /**
     * @param nome
     * @return planeta por nome.
     */
    Planeta findByNome(String nome);

    /**
     * @param id
     * @return planeta por id.
     */
    Planeta findPlanetaById(Integer id);

}
