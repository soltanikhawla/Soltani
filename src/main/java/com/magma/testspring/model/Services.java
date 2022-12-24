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
@Table(name = "T_Service")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
	
	@Column(name = "code")
   private String code;
	
	@Column(name = "libelle")
   private String libelle;
	

	@JsonIgnore()
	@OneToMany(mappedBy = "services", cascade = CascadeType.ALL)
	private List<DepDepeches>depdepeches;
	
	
	
	public Services() {
	}

	public Services(long id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<DepDepeches> getDepdepeches() {
		return depdepeches;
	}

	public void setDepdepeches(List<DepDepeches> depdepeches) {
		this.depdepeches = depdepeches;
	}


   
}
