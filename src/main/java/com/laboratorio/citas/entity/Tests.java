package com.laboratorio.citas.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

//@Data
@Entity
@Table(name="tests")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Tests {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="id_test")
	@Basic(fetch = FetchType.EAGER)
	private List<Appoinments> appoinments;
	
	
	public Tests() {
		super();
	}
	
	
	
	public Tests(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Tests [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
