package com.laboratorio.citas.service;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.entity.Appoinments;

public interface AppoinmentsService {
	
	List<Appoinments> consultarAppoinments();
	
	Optional <Appoinments> consultarAppoinmentById(int id);
	
	Appoinments guardarAppoinment(Appoinments appoinment);
	
	Optional<Appoinments> actualizarAppoinment(Appoinments appoinment);
	
	Optional<Appoinments> eliminarAppoinment(int id);
	
	Collection <Appoinments> consultarAppoinmentsByDate(LocalDate date_ap);
	
	Collection <Appoinments> consultarAppoinmentsByAffiliate(Affiliates id_affiliate);
	
}
