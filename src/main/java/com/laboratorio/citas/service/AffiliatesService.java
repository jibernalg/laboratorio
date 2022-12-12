package com.laboratorio.citas.service;

import java.util.List;
import java.util.Optional;

import com.laboratorio.citas.entity.Affiliates;

public interface AffiliatesService {

	public abstract List<Affiliates> consultarAffiliates();
	
	public abstract Optional<Affiliates> consultarAffiliatesById(int id);
	
	public abstract Affiliates guardarAffiliate(Affiliates affiliate);
	
	public abstract Optional<Affiliates> actualizarAffiliate(Affiliates affiliate);
	
	public abstract Optional<Affiliates> eliminarAffiliates(int id);
}

