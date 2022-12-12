package com.laboratorio.citas.controller;


import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.entity.Appoinments;
import com.laboratorio.citas.entity.Tests;
import com.laboratorio.citas.service.AppoinmentsService;

@ExtendWith(MockitoExtension.class)

public class AppoinmentsControllerTest {
	
	@Mock
	private AppoinmentsService appoinmentsServicesMock;
	
	@InjectMocks
	private AppoinmentsController appoinmentControllerMock;
	
	Tests test1=new Tests();
	Affiliates affiliate1=new Affiliates();
	
	Appoinments appoinment1=new Appoinments(1,LocalDate.now(),LocalTime.now(),test1,affiliate1);
	
	
	@Test
	public void testConsultarAppoinmentsOk() {
		List<Appoinments> appoinments = new ArrayList<>();
		appoinments.add(appoinment1);
		when(appoinmentsServicesMock.consultarAppoinments()).thenReturn(appoinments);
		var response = appoinmentControllerMock.consultarAppoinments();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarAppoinmentsNotOk() {
		List<Appoinments> appoinments = new ArrayList<>();
		appoinments.add(null);
		when(appoinmentsServicesMock.consultarAppoinments()).thenReturn(Collections.emptyList());
		var response = appoinmentControllerMock.consultarAppoinments();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	@Test
	public void testConsultarAppoinmentsByIdOk() {	
		Optional<Appoinments> appoinments = Optional.of(new Appoinments());	
		when(appoinmentsServicesMock.consultarAppoinmentById(1)).thenReturn(appoinments);
		var response = appoinmentControllerMock.consultarAppoinmentById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarAppoinmentsByIdNotOk() {	
			
		when(appoinmentsServicesMock.consultarAppoinmentById(1)).thenReturn(Optional.empty());
		var response = appoinmentControllerMock.consultarAppoinmentById(1);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testGuardarAppoinmentsOk() {
		var appoinments=new Appoinments();
		when(appoinmentsServicesMock.guardarAppoinment(appoinments)).thenReturn(appoinments);
		var response = appoinmentControllerMock.guardarAppoinment(appoinments);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testGuardarAppoinmentsNotOk() {
		var appoinments=new Appoinments();
		when(appoinmentsServicesMock.guardarAppoinment(appoinments)).thenReturn(null);
		var response = appoinmentControllerMock.guardarAppoinment(appoinments);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testActualizarAppoinmentsOk() {
		Appoinments checkAppoinment=new Appoinments();
		when(appoinmentsServicesMock.actualizarAppoinment(checkAppoinment)).thenReturn(Optional.of(checkAppoinment));
		var response = appoinmentControllerMock.actualizarAppoinment(checkAppoinment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testActualizarAppoinmentsNotOk() {	
		Appoinments checkAppoinment=null;
		when(appoinmentsServicesMock.actualizarAppoinment(checkAppoinment)).thenReturn(Optional.empty());
		var response = appoinmentControllerMock.actualizarAppoinment(checkAppoinment);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	public void testEliminarAppoinmentsOk() {
		Appoinments appoinment=new Appoinments();
		when(appoinmentsServicesMock.eliminarAppoinment(1)).thenReturn(Optional.of(appoinment));
		var response = appoinmentControllerMock.eliminarAppoinment(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testEliminarAppoinmentsNotOk() {
		
		when(appoinmentsServicesMock.eliminarAppoinment(1)).thenReturn(Optional.empty());
		var response = appoinmentControllerMock.eliminarAppoinment(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		
	}
	@Test
	void testConsultarAppoinmentsByDateOk() {
		Collection<Appoinments> appoinments = new ArrayList<>();
		appoinments.add(appoinment1);
		when(appoinmentsServicesMock.consultarAppoinmentsByDate(LocalDate.now())).thenReturn(appoinments);
		var response = appoinmentControllerMock.consultarAppoinmentsByDate(LocalDate.now());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarAppoinmentsByDateNotOk() {
		when(appoinmentsServicesMock.consultarAppoinmentsByDate(LocalDate.now())).thenReturn(Collections.emptyList());
		var response = appoinmentControllerMock.consultarAppoinmentsByDate(LocalDate.now());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

	@Test
	void testConsultarAppoinmentsByAffiliateOk() {
		Collection<Appoinments> appoinments = new ArrayList<>();
		appoinments.add(appoinment1);
		when(appoinmentsServicesMock.consultarAppoinmentsByAffiliate(affiliate1)).thenReturn(appoinments);
		var response = appoinmentControllerMock.consultarAppoinmentsByAffiliate(affiliate1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarAppoinmentsByAffiliateNotOk() {
		when(appoinmentsServicesMock.consultarAppoinmentsByAffiliate(affiliate1)).thenReturn(Collections.emptyList());
		var response = appoinmentControllerMock.consultarAppoinmentsByAffiliate(affiliate1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

}
