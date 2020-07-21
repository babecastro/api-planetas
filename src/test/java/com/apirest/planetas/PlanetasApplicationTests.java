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

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanetasApplicationTests {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testaPlaneta() {
		List<Planeta> planeta = planetaRepository.findAll();
		Assert.assertEquals(planeta.size(), 3);
	}

	@Test
	public void testaUmPlaneta() {
		Planeta planeta = planetaRepository.findPlanetaById(1);

	}

	@Test
	public void testaPlanetaPorNome() {
		Planeta planeta = planetaRepository.findByNome("Terra");
		Assert.assertNotNull(planeta);
	}

	@Test
	public void testaPlanetaInexistente() {
		Planeta planeta = planetaRepository.findByNome("Plutao");
		Assert.assertNull(planeta);
	}

}
