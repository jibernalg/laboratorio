package com.laboratorio.citas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratorio.citas.entity.Tests;
import com.laboratorio.citas.repository.TestsRepository;
import com.laboratorio.citas.service.TestsService;

@Service
public class TestsServiceImpl implements TestsService {
	
	@Autowired
	private TestsRepository testsRepo;
	
	@Override
	public List<Tests> consultarTests() {
		List<Tests> testsDataSource = StreamSupport.stream(this.testsRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return testsDataSource;
	}

	@Override
	public Optional<Tests> consultarTestById(int id) {		
		return this.testsRepo.findById(id);
	}

	@Override
	public Tests guardarTest(Tests test) {
		
		return this.testsRepo.save(test);
	}

	@Override
	public Optional<Tests> actualizarTest(Tests test) {
		
		Optional<Tests> optionalTest=testsRepo.findById(test.getId());
		if(optionalTest.isPresent()) {
			
			Tests actualizarTest=optionalTest.get();
			actualizarTest.setName(test.getName());
			actualizarTest.setDescription(test.getDescription());
			
			testsRepo.save(actualizarTest);
			return Optional.ofNullable(actualizarTest);
		}
			return Optional.empty();
	}

	@Override
	public Optional<Tests> eliminarTest(int id) {
		
		Optional<Tests> optionalDelete=this.testsRepo.findById(id);
		
		if(optionalDelete.isPresent()) {
			
			Tests eliminarTest = optionalDelete.get();
			
			testsRepo.delete(eliminarTest);
			return Optional.ofNullable(eliminarTest);
		}
		return Optional.empty();
	}

	

}
