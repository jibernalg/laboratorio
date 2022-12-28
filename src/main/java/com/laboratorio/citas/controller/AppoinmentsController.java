package com.laboratorio.citas.controller;



import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.entity.Appoinments;
import com.laboratorio.citas.service.AppoinmentsService;

@RestController
@RequestMapping("/appoinments")
public class AppoinmentsController {
	
	@Autowired
	private AppoinmentsService appoinmentsServiceImpl;
	
	//@GetMapping
	@RequestMapping(value="consultarAppoinments", method=RequestMethod.GET)
	public ResponseEntity<?> consultarAppoinments(){
		
		List<Appoinments> appoinmentsConsultados=this.appoinmentsServiceImpl.consultarAppoinments();
		
		if(appoinmentsConsultados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentsConsultados);
		}
	}
	//@GetMapping
	@RequestMapping(value="consultarAppoinmentById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> consultarAppoinmentById(@PathVariable int id){
		
		Optional<Appoinments> appoinmentConsultadoById=this.appoinmentsServiceImpl.consultarAppoinmentById(id);
		
		if(appoinmentConsultadoById.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentConsultadoById);
		}
	}
	
	//@PostMapping
	@RequestMapping(value="guardarAppoinment",method=RequestMethod.POST)
	public ResponseEntity<?> guardarAppoinment(@RequestBody Appoinments appoinment){
		
		Appoinments appoinmentGuardado = this.appoinmentsServiceImpl.guardarAppoinment(appoinment);
		
		if(appoinmentGuardado==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentGuardado);
		}
	}
	
	//@PutMapping
	@RequestMapping(value="actualizarAppoinment",method=RequestMethod.PUT)
	public ResponseEntity<?> actualizarAppoinment(@RequestBody Appoinments appoinment){
		
		Optional<Appoinments> appoinmentActualizado = this.appoinmentsServiceImpl.actualizarAppoinment(appoinment);
		
		if(appoinmentActualizado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentActualizado);
		}
	}
	
	//@DeleteMapping
	@RequestMapping(value="eliminarAppoinment/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAppoinment(@PathVariable int id){
		
		Optional<Appoinments> appoinmentEliminado=this.appoinmentsServiceImpl.eliminarAppoinment(id);
		
		if(appoinmentEliminado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentEliminado);
		}
	}
		
	//@GetMapping
	@RequestMapping
	public ResponseEntity<?> consultarAppoinmentsByDate(@RequestParam ("date_ap")@DateTimeFormat(pattern="dd/MM/yyyy") LocalDate date_ap){
		
		Collection<Appoinments> appoinmentsConsultadoByDate=this.appoinmentsServiceImpl.consultarAppoinmentsByDate(date_ap);
		
		if(appoinmentsConsultadoByDate.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentsConsultadoByDate);
		}
	}
	
	//@GetMapping
	@RequestMapping(value="consultarAppoinmentsByAffiliate/{id_affiliate}",method=RequestMethod.GET)
	public ResponseEntity<?> consultarAppoinmentsByAffiliate(@PathVariable Affiliates id_affiliate){
		
		Collection<Appoinments> appoinmentsConsultadoByAffiliate=this.appoinmentsServiceImpl.consultarAppoinmentsByAffiliate(id_affiliate);
		
		if(appoinmentsConsultadoByAffiliate.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(appoinmentsConsultadoByAffiliate);
		}
	}
	
}
