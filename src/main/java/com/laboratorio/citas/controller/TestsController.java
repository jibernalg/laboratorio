package com.laboratorio.citas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.laboratorio.citas.entity.Tests;
import com.laboratorio.citas.service.TestsService;

@RestController
@RequestMapping("/tests")
public class TestsController {
	
	@Autowired
	private TestsService testsServiceImpl;
	
	
	//@GetMapping
	@RequestMapping(value="consultarTests",method=RequestMethod.GET)
	public ResponseEntity<?> consultarTests(){
		
		List<Tests> testsConsultados = this.testsServiceImpl.consultarTests();
		
		if(testsConsultados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(testsConsultados);
		}
	}
	
	//@GetMapping
	@RequestMapping(value="consultarTestById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> consultarTestById(@PathVariable int id){
		
		Optional<Tests> testConsultadoById = this.testsServiceImpl.consultarTestById(id);
		
		if(testConsultadoById.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(testConsultadoById);
		}
	}
	
	//@PostMapping
	@RequestMapping(value="guardarTest",method=RequestMethod.POST)
	public ResponseEntity<?> guardarTest(@RequestBody Tests test){
		
		Tests testGuardado = this.testsServiceImpl.guardarTest(test);
		
		if(testGuardado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(testGuardado);
		}
	}
	
	//@PutMapping
	@RequestMapping(value="actualizarTest",method=RequestMethod.PUT)
	public ResponseEntity<?> actualizarTest(@RequestBody Tests test){
		
				
		Optional<Tests>testActualizado=this.testsServiceImpl.actualizarTest(test);
		
		if(testActualizado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(testActualizado);
		}
	}
	
	//@DeleteMapping
	@RequestMapping(value="eliminarTest/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> eliminarTest(@PathVariable int id){
		
		Optional<Tests>testEliminado=this.testsServiceImpl.eliminarTest(id);
		
		if(testEliminado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(testEliminado);
		}
	}
}
