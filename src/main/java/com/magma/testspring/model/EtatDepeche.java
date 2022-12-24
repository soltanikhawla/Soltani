package com.magma.testspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "T_EtatDepeches")
public class EtatDepeche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
	
	@Column(name = "libelle")
	private String libelle;
	
	@Column(name = "color")
	private String color;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "etatDepeche", cascade = CascadeType.ALL)
	private List<DepDepeches>depdepeches;
	
	
	public EtatDepeche() {
	}

	public EtatDepeche(long id, String libelle, String color) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.color =color;
	
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


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<DepDepeches> getDepdepeches() {
		return depdepeches;
	}

	public void setDepdepeches(List<DepDepeches> depdepeches) {
		this.depdepeches = depdepeches;
	}

   
}
