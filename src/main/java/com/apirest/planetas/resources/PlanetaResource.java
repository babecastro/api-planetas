package com.apirest.planetas.resources;

import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.repository.PlanetaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/planeta")
@Api(value = "API REST PLANETAS")
@CrossOrigin(origins = "*")
@Service
public class PlanetaResource {

    @Autowired
    private PlanetaRepository planetaRepository;

    @PostMapping("/planeta")
    @ApiOperation(value="Adiciona um novo planeta.")
    public Planeta adicionaPlaneta(@RequestBody Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    @GetMapping("/planeta")
    @ApiOperation(value="Lista todos os planetas.")
    public List<Planeta> listaPlanetas() {
        return planetaRepository.findAll();
    }

    @GetMapping("/planeta/{id}")
    @ApiOperation(value="Encontra planeta por id.")
    public Planeta listaUnicoPlaneta (@PathVariable(value="id") Integer id) {
        return planetaRepository.findPlanetaById(id);
    }

    @GetMapping("/planetaNome/{nome}")
    @ApiOperation(value="Encontra planeta por nome.")
    public Planeta listaPlanetaPorNome (@PathVariable(value = "nome") String nome) {
        return planetaRepository.findByName(nome);
    }

    @PutMapping
    @ApiOperation(value="Atualiza Planeta.")
    public Planeta atualizaPlaneta(@RequestBody Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    @DeleteMapping
    @ApiOperation(value="Deleta um planeta.")
    public void deletaPlaneta(@RequestBody Planeta planeta) {
        planetaRepository.delete(planeta);
    }

}
