package com.magma.testspring.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "T_EtatMateriel")
public class EtatMateriel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "libelle")
	private String libelle;

	@JsonIgnore()
	@OneToMany(mappedBy = "etatmateriel")
	private List<Materiel>materiel;
	
	
	
	public EtatMateriel() {
	}



	public EtatMateriel(long id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public List<Materiel> getMateriel() {
		return materiel;
	}



	public void setMateriel(List<Materiel> materiel) {
		this.materiel = materiel;
	}




}
