package com.magma.testspring.model;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_depDepeches")
public class DepDepeches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	
	@Column(name = "numero")
	private long numero;
	
	@Column(name = "reparageDescription")
	private String ReparageDescription; 
	
	@Column(name = "heure")
	private String Heure;
	
	@Column(name = "date_creation")
	private Timestamp dateCreation;
	
	@Column(name = "emetteur")
	private String Emetteur;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_anomalie", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Anomalie anomalie;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_materiel", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Materiel materiel;


	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_utilisateur", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Utilisateur utilisateur;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_station", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Station station;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_services", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Services services; 
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_etatDepeche", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EtatDepeche etatDepeche;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "id_typeDepeche", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TypeDepeche typeDepeche;
	
	
	public DepDepeches() {
		super();
	}



	public DepDepeches(long numero, String reparageDescription, String heure,Timestamp dateCreation, String emetteur) {

		this.numero = numero;
		this.ReparageDescription = reparageDescription;
		this.Heure = heure;
		this.dateCreation = dateCreation;
		this.Emetteur = emetteur;
	
	}
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getReparageDescription() {
		return ReparageDescription;
	}

	public void setReparageDescription(String reparageDescription) {
		this.ReparageDescription = reparageDescription;
	}

	public String getHeure() {
		return Heure;
	}

	public void setHeure(String heure) {
		this.Heure = heure;
	}

	

	public Timestamp getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}



	public String getEmetteur() {
		return Emetteur;
	}



	public void setEmetteur(String emetteur) {
		this.Emetteur = emetteur;
	}



	public Anomalie getAnomalie() {
		return anomalie;
	}



	public void setAnomalie(Anomalie anomalie) {
		this.anomalie = anomalie;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Station getStation() {
		return station;
	}



	public void setStation(Station station) {
		this.station = station;
	}



	public Services getServices() {
		return services;
	}



	public void setServices(Services services) {
		this.services = services;
	}



	public EtatDepeche getEtatDepeche() {
		return etatDepeche;
	}



	public void setEtatDepeche(EtatDepeche etatDepeche) {
		this.etatDepeche = etatDepeche;
	}



	public TypeDepeche getTypeDepeche() {
		return typeDepeche;
	}



	public void setTypeDepeche(TypeDepeche typeDepeche) {
		this.typeDepeche = typeDepeche;
	}



	public Materiel getMateriel() {
		return materiel;
	}



	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	

}
