package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Anomalie;
import com.magma.testspring.repository.AnomalieRepository;

@Service
public class AnomalieService {
	
	private final AnomalieRepository anomalieRepository;

	@Autowired
	public AnomalieService(AnomalieRepository anomalieRepository) {
		super();
		this.anomalieRepository = anomalieRepository;
	}
	
	// Find All Station  
	@Transactional
	public List<Anomalie> findAllAnomalie() {
        return anomalieRepository.findAll();
    }
	

}
