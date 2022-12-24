package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.Station;
import com.magma.testspring.repository.StationRepository;

@Service
public class StationService {
	private final StationRepository stationRepository;

	@Autowired
	public StationService(StationRepository stationRepository) {
		super();
		this.stationRepository = stationRepository;
	}
	
	// Find All Station  
	@Transactional
	public List<Station> findAllStation() {
        return stationRepository.findAll();
    }
	
	

}
