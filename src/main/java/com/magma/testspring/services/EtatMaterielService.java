package com.magma.testspring.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magma.testspring.model.EtatMateriel;
import com.magma.testspring.repository.EtatMaterielRepository;

@Service
public class EtatMaterielService {
	
	@Autowired
	private EtatMaterielRepository etatMaterielRepository;
	
	// Find All EtatMateriel  
	@Transactional
	public List<EtatMateriel> findAllEtatMateriel() {
        return etatMaterielRepository.findAll();
    }

}
