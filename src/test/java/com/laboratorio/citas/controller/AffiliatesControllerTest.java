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

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.service.AffiliatesService;



@ExtendWith(MockitoExtension.class)

public class AffiliatesControllerTest {
	
	
	@Mock
	private AffiliatesService affiliatesServicesMock;
	
	@InjectMocks
	private AffiliatesController affiliatesControllerMock;
	
	Affiliates affiliates1=new Affiliates(1,"Carlos",35,"carlos@gmail.com");
	Affiliates affiliates2=new Affiliates(2,"Anita",23,"ani@gmail.com");
	Affiliates affiliates3=new Affiliates(3,"Lucas",45,"luq@gmail.com");
	

	@Test
	public void testConsultarAffiliatesOk() {
		List<Affiliates> affiliates = new ArrayList<>();
		affiliates.add(affiliates1);
		when(affiliatesServicesMock.consultarAffiliates()).thenReturn(affiliates);
		var response = affiliatesControllerMock.consultarAffiliates();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarAffiliatesNotOk() {
		List<Affiliates> affiliates = new ArrayList<>();
		affiliates.add(null);
		when(affiliatesServicesMock.consultarAffiliates()).thenReturn(Collections.emptyList());
		var response = affiliatesControllerMock.consultarAffiliates();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	@Test
	public void testConsultarAffiliatesByIdOk() {	
		Optional<Affiliates> affiliate = Optional.of(new Affiliates());	
		when(affiliatesServicesMock.consultarAffiliatesById(1)).thenReturn(affiliate);
		var response = affiliatesControllerMock.consultarAffiliatesById(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testConsultarAffiliatesByIdNotOk() {	
			
		when(affiliatesServicesMock.consultarAffiliatesById(1)).thenReturn(Optional.empty());
		var response = affiliatesControllerMock.consultarAffiliatesById(1);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testGuardarAffiliateOk() {
		var affiliate=new Affiliates();
		when(affiliatesServicesMock.guardarAffiliate(affiliate)).thenReturn(affiliate);
		var response = affiliatesControllerMock.guardarAffiliate(affiliate);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testGuardarAffiliateNotOk() {
		var affiliate=new Affiliates();
		when(affiliatesServicesMock.guardarAffiliate(affiliate)).thenReturn(null);
		var response = affiliatesControllerMock.guardarAffiliate(affiliate);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	@Test
	public void testActualizarAffiliateOk() {
		Affiliates checkAffiliates=new Affiliates();
		when(affiliatesServicesMock.actualizarAffiliate(checkAffiliates)).thenReturn(Optional.of(checkAffiliates));
		var response = affiliatesControllerMock.actualizarAffiliate(checkAffiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testActualizarAffiliateNotOk() {	
		Affiliates checkAffiliates=null;
		when(affiliatesServicesMock.actualizarAffiliate(checkAffiliates)).thenReturn(Optional.empty());
		var response = affiliatesControllerMock.actualizarAffiliate(checkAffiliates);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	public void testEliminarAffiliatesOk() {
		Affiliates affiliate=new Affiliates();
		when(affiliatesServicesMock.eliminarAffiliates(1)).thenReturn(Optional.of(affiliate));
		var response = affiliatesControllerMock.eliminarAffiliates(1);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testEliminarAffiliatesNotOk() {
		
		when(affiliatesServicesMock.eliminarAffiliates(1)).thenReturn(Optional.empty());
		var response = affiliatesControllerMock.eliminarAffiliates(1);
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		
	}

}
