package com.laboratorio.citas.service;

import java.util.List;
import java.util.Optional;

import com.laboratorio.citas.entity.Tests;

public interface TestsService {
	
	List<Tests> consultarTests();
	
	Optional<Tests> consultarTestById(int id);
	
	Tests guardarTest(Tests test);
	
	Optional<Tests> actualizarTest(Tests test);
	
	Optional<Tests> eliminarTest(int id);
	
}
