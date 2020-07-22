package com.apirest.planetas.services;

import com.apirest.planetas.components.StarWarsComponent;
import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.models.PlanetaStarWars;
import com.apirest.planetas.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Bárbara Castro
 */
@Service
public class PlanetaService {

    @Autowired
    StarWarsComponent starWarsComponent;

    @Autowired
    PlanetaRepository planetaRepository;


    /**
     * @param nome
     * @return planeta por nome.
     * @throws Exception
     */
    public Planeta findPlanetaByName(String nome) throws Exception {
        try {
            Planeta planeta = planetaRepository.findByNome(nome);
            planeta.setQtdFilmes(adicionaQuantidadeFilmes(planeta.getId()));
            return planeta;
        } catch (Exception e) {
            throw new Exception("Nao foi possível encontrar Planeta com esse nome. Tente novamente.", e);
        }
    }

    /**
     * @param id
     * @return planeta por id.
     * @throws Exception
     */
    public Planeta findPlanetaById(Integer id) throws Exception {
        try {
            Planeta planeta = planetaRepository.findPlanetaById(id);
            planeta.setQtdFilmes(adicionaQuantidadeFilmes(id));
            return planeta;
        } catch (Exception e) {
            throw new Exception("Não foi possível encontrar planeta com esse id. Tente novamente.", e);
        }
    }

    /**
     * @param planeta
     * @return planeta adicionado.
     * @throws Exception
     */
    public Planeta adicionaPlaneta(Planeta planeta) throws Exception {
        Planeta planetaExistente = planetaRepository.findPlanetaById(planeta.getId());
        if(!planetaExistente.getId().equals(planeta.getId())) {
            return planetaRepository.save(planeta);
        }
        throw new Exception("Nao foi possivel salvar esse planeta. Id Existente.");
    }

    /**
     * @param id
     */
    public void deletaPlaneta(Integer id) {
        planetaRepository.deleteById(id);
    }

    /**
     * @param id
     * @return quantidade de filmes.
     */
    public Integer adicionaQuantidadeFilmes(Integer id) {
        Planeta planeta = new Planeta();
        PlanetaStarWars planetaStarWars = starWarsComponent.getPlaneta(id);
        planeta.setQtdFilmes(planetaStarWars.getFilms().size());
        return planeta.getQtdFilmes();
    }

    /**
     * @return todos os planetas.
     */
    public List<Planeta> getPlanetas() {
        List<Planeta> planetasRepository = planetaRepository.findAll();
        List<Planeta> planetas = new ArrayList<>();
        for(Planeta planeta1 : planetasRepository) {
            Planeta planeta = new Planeta();
            planeta.set_id(planeta1.get_id());
            planeta.setId(planeta1.getId());
            planeta.setNome(planeta1.getNome());
            planeta.setClima(planeta1.getClima());
            planeta.setTerreno(planeta1.getTerreno());
            planeta.setQtdFilmes(adicionaQuantidadeFilmes(planeta1.getId()));
            planetas.add(planeta);
        }
        return planetas;
    }
}
