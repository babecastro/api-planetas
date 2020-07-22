package com.apirest.planetas;

import com.apirest.planetas.models.Planeta;
import com.apirest.planetas.repository.PlanetaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetasApplicationTests {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Test
	public void testaPlaneta() {
		List<Planeta> planeta = planetaRepository.findAll();
		Assert.assertEquals(planeta.size(), 2);
	}

	@Test
	public void testaUmPlaneta() {
		Planeta planeta = planetaRepository.findPlanetaById(1);
		Assert.assertEquals(planeta.getId().longValue(), 1);
	}

	@Test
	public void testaPlanetaPorNome() {
		Planeta planeta = planetaRepository.findByNome("Tatooine");
		Assert.assertNotNull(planeta);
	}

	@Test
	public void testaPlanetaInexistente() throws Exception {
		Planeta planeta = planetaRepository.findByNome("Plutao");
		Assert.assertNull(planeta);
	}

}
