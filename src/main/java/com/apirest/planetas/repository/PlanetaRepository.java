package com.apirest.planetas.repository;


import com.apirest.planetas.models.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetaRepository extends MongoRepository <Planeta, Integer> {

    Planeta findByName(String nome);

    Planeta findPlanetaById(Integer id);

}
