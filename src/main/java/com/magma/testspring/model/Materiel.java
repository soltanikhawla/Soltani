package com.magma.testspring.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "T_materiel")
public class Materiel  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "libelle")
    private String libelle;
	
	@Column(name = "emplacement")
    private String emplacement;
	
	@Column(name = "numerotation")
    private int numerotation;
	
	@Column(name = "numero_serie")
    private int numeroSerie;
	
	@Column(name = "mise_en_place")
    private Timestamp miseEnPlace;
	
	@JsonIgnore()
	@OneToMany(mappedBy = "materiel")
	private List<Anomalie>anomalie;

	@JsonIgnore()
	@OneToMany(mappedBy = "materiel", cascade = CascadeType.ALL)
	private List<DepDepeches>depDepeches;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_typemateriel", referencedColumnName = "id")
	private TypeMateriel typemateriel;
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_etatmateriel", referencedColumnName = "id")
	private EtatMateriel etatmateriel;
	
	
	
	public Materiel() {
		
	}

	public Materiel(long id, String libelle, String emplacement, int numerotation, int numeroSerie, Timestamp miseEnPlace) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.emplacement = emplacement;
		this.numerotation = numerotation;
		this.numeroSerie = numeroSerie;
		this.miseEnPlace = miseEnPlace;
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
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getnumerotation() {
		return numerotation;
	}
	public void setnumerotation(int numerotation) {
		this.numerotation = numerotation;
	}
	public int getnumeroSerie() {
		return numeroSerie;
	}
	public void setnumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Timestamp getMiseEnPlace() {
		return miseEnPlace;
	}
	public void setMiseEnPlace(Timestamp miseEnPlace) {
		this.miseEnPlace = miseEnPlace;
	}
	public EtatMateriel getEtatmateriel() {
		return etatmateriel;
	}
	public void setEtatmateriel(EtatMateriel etatmateriel) {
		this.etatmateriel = etatmateriel;
	}

	public List<Anomalie> getAnomalie() {
		return anomalie;
	}

	public void setAnomalie(List<Anomalie> anomalie) {
		this.anomalie = anomalie;
	}

	public TypeMateriel getTypemateriel() {
		return typemateriel;
	}

	public void setTypemateriel(TypeMateriel typemateriel) {
		this.typemateriel = typemateriel;
	}

	public List<DepDepeches> getDepDepeches() {
		return depDepeches;
	}

	public void setDepDepeches(List<DepDepeches> depDepeches) {
		this.depDepeches = depDepeches;
	}


	
	
	
	
    
}
