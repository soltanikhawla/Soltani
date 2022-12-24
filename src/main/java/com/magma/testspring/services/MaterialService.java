package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Materiel;
import com.magma.testspring.repository.MaterialRepository;

@Service
public class MaterialService {
	
	private final MaterialRepository materialRepository;

	@Autowired
	public MaterialService(MaterialRepository materialRepository) {
		super();
		this.materialRepository = materialRepository;
	}
	
	// Find All Material  
		@Transactional
		public List<Materiel> findAllMaterial() {
	        return materialRepository.findAll();
	    }
	
	

}
