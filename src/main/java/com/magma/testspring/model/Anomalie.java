package com.magma.testspring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "T_Anomalie")
public class Anomalie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "libelle")
	private String libelle;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_materiel", referencedColumnName = "id")
	private Materiel materiel;

	@JsonIgnore()
	@OneToMany(mappedBy = "anomalie", cascade = CascadeType.ALL)
	private List<DepDepeches>depDepeches;


	public Anomalie() {
		
	}
	
	public Anomalie(long id, String libelle) {
		super();
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

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public List<DepDepeches> getDepDepeches() {
		return depDepeches;
	}

	public void setDepDepeches(List<DepDepeches> depDepeches) {
		this.depDepeches = depDepeches;
	}


	
}
