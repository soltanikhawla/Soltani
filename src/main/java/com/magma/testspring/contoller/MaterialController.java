package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Anomalie;
import com.magma.testspring.model.DepDepeches;
import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.model.EtatMateriel;
import com.magma.testspring.model.Materiel;
import com.magma.testspring.model.Services;
import com.magma.testspring.model.Station;
import com.magma.testspring.model.TypeDepeche;
import com.magma.testspring.model.TypeMateriel;
import com.magma.testspring.model.Utilisateur;
import com.magma.testspring.repository.EtatMaterielRepository;
import com.magma.testspring.repository.MaterialRepository;
import com.magma.testspring.repository.TypeMaterielRepository;
import com.magma.testspring.services.MaterialService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/material")
public class MaterialController {
	
	private final MaterialService materialService;
	
	@Autowired 
	private EtatMaterielRepository etatMaterielRepository;
	
	@Autowired
	private TypeMaterielRepository typeMaterielRepository;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	

	public MaterialController(MaterialService materialService) {
		super();
		this.materialService = materialService;
	}
	
	//Find All Users 
	@GetMapping("/allMaterial")
	public List<Materiel> findAllMaterial(){
		return materialService.findAllMaterial();
	}
	
	//Add materiel 
    @PostMapping("/addMaterial/{etatMaterialId}/{typeMaterielId}")
    public ResponseEntity<?> addDepDepeches(@RequestBody Materiel materiel, @PathVariable(value = "etatMaterialId") Long etatMaterialId,
    		@PathVariable(value = "typeMaterielId") Long typeMaterielId) { 
    	EtatMateriel etatMateriel = etatMaterielRepository.getOne(etatMaterialId);
    	TypeMateriel typeMateriel = typeMaterielRepository.getOne(typeMaterielId);

    	materiel.setTypemateriel(typeMateriel);
    	materiel.setEtatmateriel(etatMateriel);
    	
    	materialRepository.save(materiel);
 
        return ResponseEntity.ok().body( materiel);
    }

}
