package com.laboratorio.citas.repository;

import java.time.LocalDate;
import java.util.Collection;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.entity.Appoinments;


public interface AppoinmentsRepository extends CrudRepository<Appoinments, Integer>{
	
	@Query(value="SELECT a FROM Appoinments a WHERE a.id_affiliate=:id_affiliate")
	Collection<Appoinments> consultarAppoinmentsByAffiliate(Affiliates id_affiliate);
	
	@Query(value="SELECT a FROM Appoinments a WHERE a.date_ap=:date_ap order by a.id_affiliate")
	Collection<Appoinments> consultarAppoinmentsByDate(LocalDate date_ap);
	
}
