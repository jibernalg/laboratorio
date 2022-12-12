package com.laboratorio.citas.service.impl;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.entity.Appoinments;
import com.laboratorio.citas.repository.AppoinmentsRepository;
import com.laboratorio.citas.service.AppoinmentsService;

@Service
public class AppoinmentsServiceImpl implements AppoinmentsService {
	
	@Autowired
	private AppoinmentsRepository appoRepo;
	
	@Override
	public List<Appoinments> consultarAppoinments() {
		List<Appoinments> appoinmentsDataSource=StreamSupport.stream(this.appoRepo.findAll().spliterator(), false).collect(Collectors.toList());
		return appoinmentsDataSource;
	}

	@Override
	public Optional<Appoinments> consultarAppoinmentById(int id) {	
		return this.appoRepo.findById(id);
	}

	@Override
	public Appoinments guardarAppoinment(Appoinments appoinment) {
		
		return this.appoRepo.save(appoinment);
	}

	@Override
	public Optional<Appoinments> actualizarAppoinment(Appoinments appoinment) {
		
		Optional<Appoinments> optionalAppoinment=appoRepo.findById(appoinment.getId());
		if(optionalAppoinment.isPresent()) {
			
			Appoinments actualizarAppoinment=optionalAppoinment.get();
			actualizarAppoinment.setDate_ap(appoinment.getDate_ap());
			actualizarAppoinment.setHour_ap(appoinment.getHour_ap());
			actualizarAppoinment.setId_test(appoinment.getId_test());
			actualizarAppoinment.setId_affiliate(appoinment.getId_affiliate());
			
			appoRepo.save(actualizarAppoinment);
			return Optional.ofNullable(actualizarAppoinment);
		}
			return Optional.empty();
	}

	@Override
	public Optional<Appoinments> eliminarAppoinment(int id) {
		
		Optional<Appoinments> optionalDelete=this.appoRepo.findById(id);
		
		if(optionalDelete.isPresent()) {
		
			Appoinments eliminarAppoinment = optionalDelete.get();
			
			appoRepo.delete(eliminarAppoinment);
			return Optional.ofNullable(eliminarAppoinment);
		}
		return Optional.empty();
	}

	@Override
	public Collection<Appoinments> consultarAppoinmentsByDate(LocalDate date_ap) {
	
		return this.appoRepo.consultarAppoinmentsByDate(date_ap);
		
		
	}

	@Override
	public Collection<Appoinments> consultarAppoinmentsByAffiliate(Affiliates id_affiliate) {
		
		return this.appoRepo.consultarAppoinmentsByAffiliate(id_affiliate);
		
	}
}
