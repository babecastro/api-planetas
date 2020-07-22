package com.apirest.planetas;

import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.repository.PlanetaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Bárbara Castro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetasApplicationTests {

	@Autowired
	private PlanetaRepository planetaRepository;

	/**
	 * Verifica se existe pelo menos um objeto Planeta.
	 */
	@Test
	public void testaPlaneta() {
		List<Planeta> planeta = planetaRepository.findAll();
		Assert.assertNotNull(planeta);
	}

	/**
	 * Verifica se existe um planeta com id 1.
	 */
	@Test
	public void testaUmPlaneta() {
		Planeta planeta = planetaRepository.findPlanetaById(1);
		Assert.assertEquals(planeta.getId().longValue(), 1);
	}

	/**
	 * Verifica planeta por nome.
	 */
	@Test
	public void testaPlanetaPorNome() {
		Planeta planeta = planetaRepository.findByNome("Tatooine");
		Assert.assertNotNull(planeta);
	}

	/**
	 * Verifica um planeta inexistente.
	 */
	@Test
	public void testaPlanetaInexistente() {
		Planeta planeta = planetaRepository.findByNome("Plutao");
		Assert.assertNull(planeta);
	}

}
