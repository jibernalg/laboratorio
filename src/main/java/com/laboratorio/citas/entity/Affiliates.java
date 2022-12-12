package com.laboratorio.citas.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="affiliates")
public class Affiliates {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="mail")
	private String mail;
	
	@OneToMany(mappedBy="id_affiliate")
	private List<Appoinments> appoinments;
	
	
	
	
	public Affiliates() {
		super();
	}
	

	public Affiliates(int id, String name, int age, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mail = mail;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}



	@Override
	public String toString() {
		return "Affiliates [id=" + id + ", name=" + name + ", age=" + age + ", mail=" + mail + "]";
	}
	
	
	
	
	
}
