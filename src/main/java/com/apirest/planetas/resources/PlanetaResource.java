package com.apirest.planetas.resources;

import com.apirest.planetas.services.PlanetaService;
import com.apirest.planetas.models.Planeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    private PlanetaService planetaService;

    @PostMapping("/planeta")
    @ApiOperation(value="Adiciona um novo planeta.")
    public Planeta adicionaPlaneta(@RequestBody Planeta planeta) throws Exception {
        return planetaService.adicionaPlaneta(planeta);
    }

    @GetMapping("/planeta")
    @ApiOperation(value="Lista todos os planetas.")
    public List<Planeta> listaPlanetas() {
       return planetaService.getPlanetas();
    }

    @GetMapping("/planeta/{id}")
    @ApiOperation(value="Encontra planeta por id.")
    public Planeta listaUnicoPlaneta (@PathVariable(value="id") Integer id) throws Exception {
        return planetaService.findPlanetaById(id);
    }

    @GetMapping("/planetaNome/{nome}")
    @ApiOperation(value="Encontra planeta por nome.")
    public Planeta listaPlanetaPorNome (@PathVariable(value = "nome") String nome) throws Exception {
        return planetaService.findPlanetaByName(nome);
    }

    @DeleteMapping("/deletaPlaneta/{id}")
    @ApiOperation(value="Deleta um planeta.")
    public void deletaPlaneta(@PathVariable(value="id") Integer id) {
        planetaService.deletaPlaneta(id);
    }

}
