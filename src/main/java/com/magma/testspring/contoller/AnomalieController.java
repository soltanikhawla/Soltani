package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Anomalie;
import com.magma.testspring.model.Materiel;
import com.magma.testspring.repository.AnomalieRepository;
import com.magma.testspring.repository.MaterialRepository;
import com.magma.testspring.services.AnomalieService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/anomalie")
public class AnomalieController {
	
	private final AnomalieService anomalieService;
	private final AnomalieRepository anomalieRepository;
	private final MaterialRepository materialRepository;

	public AnomalieController(AnomalieService anomalieService, MaterialRepository materialRepository, AnomalieRepository anomalieRepository) {
		super();
		this.anomalieService = anomalieService;
		this.materialRepository = materialRepository;
		this.anomalieRepository = anomalieRepository;
	}
	
	//Find All Users 
	@GetMapping("/allAnomalie")
	public List<Anomalie> findAllAnomalie(){
		return anomalieService.findAllAnomalie();
	}
    //add anomalie
	@PostMapping("/addAnomalie/{equipementId}")
	public ResponseEntity<?> addAnomalie(@RequestBody Anomalie anomalie,@PathVariable(value = "equipementId") Long equipementId){
		Materiel materiel = materialRepository.getOne(equipementId);
	 	anomalie.setMateriel(materiel);
	 	anomalieRepository.save(anomalie);
	 	  return ResponseEntity.ok().body( anomalie);
	}
}
