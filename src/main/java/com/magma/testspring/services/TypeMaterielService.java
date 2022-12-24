package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Materiel;
import com.magma.testspring.model.TypeMateriel;
import com.magma.testspring.repository.TypeMaterielRepository;

@Service
public class TypeMaterielService {
	@Autowired
	private TypeMaterielRepository typeMaterielRepository;
	
	// Find All TypeMateriel  
	@Transactional
	public List<TypeMateriel> findAllTypeMateriel() {
        return typeMaterielRepository.findAll();
    }

}
