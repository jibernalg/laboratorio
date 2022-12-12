package com.laboratorio.citas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.laboratorio.citas.entity.Affiliates;
import com.laboratorio.citas.repository.AffiliatesRepository;
import com.laboratorio.citas.service.AffiliatesService;

@Service
public class AffiliatesServiceImpl implements AffiliatesService{
	@Autowired
	private AffiliatesRepository affiliatesRepo;
	
	@Override
	public List<Affiliates> consultarAffiliates(){
		List<Affiliates> affiliatesDataSource = StreamSupport.stream(this.affiliatesRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return affiliatesDataSource;
	}
	
	@Override
	public Optional<Affiliates> consultarAffiliatesById(int id) {
		return this.affiliatesRepo.findById(id);
	}
	
	@Override
	public Affiliates guardarAffiliate(Affiliates affiliate) {
		
		return this.affiliatesRepo.save(affiliate);
	}
	
	@Override
	public Optional<Affiliates> actualizarAffiliate(Affiliates affiliate) {
			
		Optional<Affiliates> optionalAffiliate = affiliatesRepo.findById(affiliate.getId());
		if (optionalAffiliate.isPresent()) {
			
			Affiliates actualizarAffiliate = optionalAffiliate.get();
			actualizarAffiliate.setName(affiliate.getName());
			actualizarAffiliate.setAge(affiliate.getAge());
			actualizarAffiliate.setMail(affiliate.getMail());
			
			affiliatesRepo.save(actualizarAffiliate);
			return Optional.ofNullable(actualizarAffiliate);
		}
			return Optional.empty();
	}
	
	@Override
	public Optional<Affiliates> eliminarAffiliates(int id) {
		
		Optional<Affiliates> optionalDelete=this.affiliatesRepo.findById(id);
		
		if (optionalDelete.isPresent()) {
			
			Affiliates eliminarAffiliates = optionalDelete.get();
								
			affiliatesRepo.delete(eliminarAffiliates);
			return Optional.ofNullable(eliminarAffiliates);
		}
			return Optional.empty();
		
	}
}
