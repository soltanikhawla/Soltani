package com.magma.testspring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magma.testspring.model.DepDepeches;
import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.repository.DepDepechesRepository;

@Service
public class DepDepechesService {
	
	private final DepDepechesRepository depDepechesRepository;

	@Autowired
	public DepDepechesService(DepDepechesRepository depDepechesRepository) {
		super();
		this.depDepechesRepository = depDepechesRepository;
	}
	
	@Transactional
	public void deleteDepeche(Long depecheId) {
		DepDepeches depDepeches = depDepechesRepository.findDepecheById(depecheId);
		depDepechesRepository.delete(depDepeches);
    }
	
	@Transactional
    public void updateEtatDepeche(EtatDepeche etatDepeche, DepDepeches depDepeches) {
		depDepeches.setEtatDepeche(etatDepeche);
		depDepechesRepository.save(depDepeches);
    }
	
	@Transactional
    public long  nombreDepecheToDo() {
		return depDepechesRepository.nombreDepecheTodo();
    }
	
	@Transactional
    public long  nombreDepecheOnGoing() {
		return depDepechesRepository.nombreDepecheOnGoing();
	}
	
	@Transactional
    public long  nombreDepecheDone() {
		return depDepechesRepository.nombreDepecheDone();
    }
	// find  depeche by id
	@Transactional
	public DepDepeches getDepecheById(Long id) {
		return depDepechesRepository.findById(id).orElse(null);
	}
	
}
