package com.magma.testspring.model;

import java.io.Serializable;

public class NombreDepecheParStatus implements Serializable{
	
	private final long nombre;

	public NombreDepecheParStatus(long nombre) {
		super();
		this.nombre = nombre;
	}

	public long getNombre() {
		return nombre;
	}
	
	

}
