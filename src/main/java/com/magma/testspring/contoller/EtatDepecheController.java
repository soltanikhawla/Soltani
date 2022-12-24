package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.DepDepeches;
import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.services.DepDepechesService;
import com.magma.testspring.services.EtatDepecheService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/api/vi/etatDepeche"})
public class EtatDepecheController {
	private final EtatDepecheService etatDepecheService;
	private final DepDepechesService depDepechesService;
	
	@Autowired
	public EtatDepecheController(EtatDepecheService etatDepecheService, DepDepechesService depDepechesService) {
		super();
		this.etatDepecheService = etatDepecheService;
		this.depDepechesService = depDepechesService;
	}
	
	
	//find All Status
	@GetMapping("/allStatus")
	public List<EtatDepeche> getAllStatus(){
		return etatDepecheService.findAllStatus();
	}
	
	//update status etat depeche
	@GetMapping("/updateStatusToDepeche/{depecheId}/{statusId}")
	public ResponseEntity<?> updateStatusToDepeche(@PathVariable Long depecheId, @PathVariable Long statusId){
		EtatDepeche etatDepeche = etatDepecheService.getStatusById(statusId);
		DepDepeches depDepeches = depDepechesService.getDepecheById(depecheId);
		etatDepecheService.updateStatusToDepeche(depDepeches, etatDepeche);
		return ResponseEntity.noContent().build();
	}

}
