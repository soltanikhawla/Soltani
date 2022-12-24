package com.magma.testspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.DepDepeches;
import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.repository.DepDepechesRepository;
import com.magma.testspring.repository.EtatDepecheRepository;

@Service
public class EtatDepecheService {
	private final EtatDepecheRepository etatDepecheRepository;
	private final DepDepechesRepository depDepechesRepository;
	
	@Autowired
	public EtatDepecheService(EtatDepecheRepository etatDepecheRepository,
			DepDepechesRepository depDepechesRepository) {
		super();
		this.etatDepecheRepository = etatDepecheRepository;
		this.depDepechesRepository = depDepechesRepository;
	}
	
	//find all etat depeche
	@Transactional
	public List<EtatDepeche> findAllStatus(){
		return etatDepecheRepository.findAll();
	}
	
	// find etat depeche by id
	@Transactional
	public EtatDepeche getStatusById(Long id) {
		return etatDepecheRepository.findById(id).orElse(null);
	}
	
	//update status to depeche
	@Transactional
	public void updateStatusToDepeche(DepDepeches depDepeches, EtatDepeche etatDepeche) {
		depDepeches.setEtatDepeche(etatDepeche);
		depDepechesRepository.save(depDepeches);
	}
	

}
