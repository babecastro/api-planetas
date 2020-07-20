package com.apirest.planetas.repository;


import com.apirest.planetas.models.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanetaRepository extends MongoRepository <Planeta, String> {

    Planeta findByNome(String nome);

    Planeta findPlanetaById(Integer id);

}
