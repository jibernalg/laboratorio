package com.laboratorio.citas.controller;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;


import com.laboratorio.citas.entity.Tests;
import com.laboratorio.citas.service.TestsService;

@ExtendWith(MockitoExtension.class)

public class TestsControllerTest {
	
	@Mock
	private TestsService testsServicesMock;
	
	@InjectMocks
	private TestsController testsControllerMock;
	
	Tests test1=new Tests(1,"Hierro","Examen Sangre");
	Tests test2=new Tests(2,"Globulos blancos","Examen Sangre");
	Tests test3=new Tests(3,"Plaquetas","Examen Sangre");

	@Test
	public void testConsultarTestsOk() {
		List<Tests> tests = new ArrayList<>();
		tests.add(test1);
		when(testsServicesMock.consultarTests()).thenReturn(tests);
		var response = testsControllerMock.consultarTests();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarTestsNotOk() {
		List<Tests> tests = new ArrayList<>();
		tests.add(null);
		when(testsServicesMock.consultarTests()).thenReturn(Collections.emptyList());
		var response = testsControllerMock.consultarTests();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	@Test
	public void testConsultarTestsByIdOk() {	
		Optional<Tests> tests = Optional.of(new Tests());	
		when(testsServicesMock.consultarTestById(1)).thenReturn(tests);
		var response = testsControllerMock.consultarTestById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarTestsByIdNotOk() {	
			
		when(testsServicesMock.consultarTestById(1)).thenReturn(Optional.empty());
		var response = testsControllerMock.consultarTestById(1);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testGuardarTestsOk() {
		var tests=new Tests();
		when(testsServicesMock.guardarTest(tests)).thenReturn(tests);
		var response = testsControllerMock.guardarTest(tests);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testGuardarTestsNotOk() {
		var tests=new Tests();
		when(testsServicesMock.guardarTest(tests)).thenReturn(null);
		var response = testsControllerMock.guardarTest(tests);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testActualizarTestsOk() {
		Tests checkTests=new Tests();
		when(testsServicesMock.actualizarTest(checkTests)).thenReturn(Optional.of(checkTests));
		var response = testsControllerMock.actualizarTest(checkTests);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testActualizarTestsNotOk() {	
		Tests checkTests=null;
		when(testsServicesMock.actualizarTest(checkTests)).thenReturn(Optional.empty());
		var response = testsControllerMock.actualizarTest(checkTests);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	public void testEliminarTestsOk() {
		Tests tests=new Tests();
		when(testsServicesMock.eliminarTest(1)).thenReturn(Optional.of(tests));
		var response = testsControllerMock.eliminarTest(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testEliminarTestsNotOk() {
		
		when(testsServicesMock.eliminarTest(1)).thenReturn(Optional.empty());
		var response = testsControllerMock.eliminarTest(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		
	}

}
