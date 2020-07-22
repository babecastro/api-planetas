package com.apirest.planetas.resources;

import com.apirest.planetas.controller.StarWarsController;
import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.models.PlanetaStarWars;
import com.apirest.planetas.repository.PlanetaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Bárbara Castro
 */
@RestController
@RequestMapping(value="/api")
@Api(value = "API REST PLANETAS")
@CrossOrigin(origins = "*")
@Service
public class PlanetaResource {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private StarWarsController starWarsController;

    @PostMapping("/planeta")
    @ApiOperation(value="Adiciona um novo planeta.")
    public Planeta adicionaPlaneta(@RequestBody Planeta planeta) throws Exception {
        Planeta planetaExistente = planetaRepository.findPlanetaById(planeta.getId());
        if(!planetaExistente.getId().equals(planeta.getId())) {
            return planetaRepository.save(planeta);
        }
        throw new Exception("Nao foi possivel salvar esse planeta. Id Existente.");
    }

    @GetMapping("/planeta")
    @ApiOperation(value="Lista todos os planetas.")
    public List<Planeta> listaPlanetas() {
        List<Planeta> planetas = getPlanetas();
        return planetas;
    }

    @GetMapping("/planeta/{id}")
    @ApiOperation(value="Encontra planeta por id.")
    public Planeta listaUnicoPlaneta (@PathVariable(value="id") Integer id) throws Exception {
        try {
            Planeta planeta = planetaRepository.findPlanetaById(id);
            planeta.setQtdFilmes(adicionaQuantidadeFilmes(id));
            return planeta;
        } catch (Exception e) {
            throw new Exception("Não foi possível encontrar planeta com esse id. Tente novamente.", e);
        }
    }

    @GetMapping("/planetaNome/{nome}")
    @ApiOperation(value="Encontra planeta por nome.")
    public Planeta listaPlanetaPorNome (@PathVariable(value = "nome") String nome) throws Exception {
        try {
            Planeta planeta = planetaRepository.findByNome(nome);
            planeta.setQtdFilmes(adicionaQuantidadeFilmes(planeta.getId()));
            return planeta;
        } catch (Exception e) {
            throw new Exception("Nao foi possível encontrar Planeta com esse nome. Tente novamente.", e);
        }
    }

    @DeleteMapping("/deletaPlaneta/{id}")
    @ApiOperation(value="Deleta um planeta.")
    public void deletaPlaneta(@PathVariable(value="id") Integer id) {
        planetaRepository.deleteById(id);
    }

    /**
     * @param id
     * @return quantidade de filmes da api do Star Wars.
     */
    public Integer adicionaQuantidadeFilmes(Integer id) {
        Planeta planeta = new Planeta();
        PlanetaStarWars planetaStarWars = starWarsController.getPlaneta(id);
        planeta.setQtdFilmes(planetaStarWars.getFilms().size());
        return planeta.getQtdFilmes();
    }

    /**
     * @return planetas.
     */
    private List<Planeta> getPlanetas() {
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
