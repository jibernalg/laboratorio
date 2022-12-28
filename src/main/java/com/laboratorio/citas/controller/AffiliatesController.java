package com.laboratorio.citas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.service.AffiliatesService;

@RestController
@RequestMapping("/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesServiceImpl;
	
	//@GetMapping
	@RequestMapping(value="consultarAffiliates",method=RequestMethod.GET)
	public ResponseEntity<?> consultarAffiliates(){
		
		List<Affiliates> affiliatesConsultados = this.affiliatesServiceImpl.consultarAffiliates();
		
		if(affiliatesConsultados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliatesConsultados);
		}
	}
	
	//@GetMapping
	@RequestMapping(value="consultarAffiliatesById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> consultarAffiliatesById(@PathVariable ("id") int id){
		
		Optional<Affiliates> affiliatesConsultadosById = this.affiliatesServiceImpl.consultarAffiliatesById(id);
		
		if(affiliatesConsultadosById.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliatesConsultadosById);
		}
	}
	
		
	//@PostMapping
	@RequestMapping(value="guardarAffiliates",method=RequestMethod.POST)
	public ResponseEntity<?> guardarAffiliate(@RequestBody Affiliates affiliate){
		
		Affiliates affiliateGuardado = this.affiliatesServiceImpl.guardarAffiliate(affiliate);
		
		if(affiliateGuardado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateGuardado);
		}
	}
	
	//@PutMapping
	@RequestMapping(value="actualizarAffiliates",method=RequestMethod.PUT)
	public ResponseEntity<?> actualizarAffiliate(@RequestBody Affiliates affiliate){
		
		
		Optional<Affiliates>affiliateActualizado=this.affiliatesServiceImpl.actualizarAffiliate(affiliate);
		if(affiliateActualizado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(affiliateActualizado);
		}	
	}
	
	//@DeleteMapping
	@RequestMapping(value="eliminarAffiliates/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAffiliates(@PathVariable int id){

		Optional<Affiliates>affiliateEliminado=this.affiliatesServiceImpl.eliminarAffiliates(id);
		
		if(affiliateEliminado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(affiliateEliminado);
		}
	}
}
