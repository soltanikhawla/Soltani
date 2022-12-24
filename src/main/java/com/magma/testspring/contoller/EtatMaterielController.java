package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.EtatDepeche;
import com.magma.testspring.model.EtatMateriel;
import com.magma.testspring.services.EtatMaterielService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/api/v1/etatMateriel"})
public class EtatMaterielController {
	
	@Autowired
	private EtatMaterielService etatMaterielService;

	//find All EtatMateriel
	@GetMapping("/allEtatMateriel")
	public List<EtatMateriel> getAllEtatMateriel(){
		return etatMaterielService.findAllEtatMateriel();
	}
}
