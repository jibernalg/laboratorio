package com.laboratorio.citas.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

//@Data
@Entity
@Table(name="appoinments")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Appoinments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_ap")
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate date_ap;
	
	@Column(name="hour_ap")
	@JsonFormat(pattern="HH:mm")
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime hour_ap;
	
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name="id_test")
	private Tests id_test;
	
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name="id_affiliate")
	private Affiliates id_affiliate;

	
	
	public Appoinments() {
		super();
	}


	public Appoinments(int id, LocalDate date_ap, LocalTime hour_ap, Tests id_test, Affiliates id_affiliate) {
		this.id = id;
		this.date_ap = date_ap;
		this.hour_ap = hour_ap;
		this.id_test = id_test;
		this.id_affiliate = id_affiliate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_ap() {
		return date_ap;
	}

	public void setDate_ap(LocalDate date_ap) {
		this.date_ap = date_ap;
	}

	public LocalTime getHour_ap() {
		return hour_ap;
	}

	public void setHour_ap(LocalTime hour_ap) {
		this.hour_ap = hour_ap;
	}

	public Tests getId_test() {
		return id_test;
	}

	public void setId_test(Tests id_test) {
		this.id_test = id_test;
	}

	public Affiliates getId_affiliate() {
		return id_affiliate;
	}

	public void setId_affiliate(Affiliates id_affiliate) {
		this.id_affiliate = id_affiliate;
	}
		
					
}
