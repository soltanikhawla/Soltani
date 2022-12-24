package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.EtatMateriel;
import com.magma.testspring.model.TypeMateriel;
import com.magma.testspring.services.TypeMaterielService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/api/v1/typeMateriel"})
public class TypeMaterielController {
	
	@Autowired
	private TypeMaterielService typeMaterielService;
	
	
	//find All EtatMateriel
	@GetMapping("/allTypeMateriel")
	public List<TypeMateriel> getAllTypeMateriel(){
		return typeMaterielService.findAllTypeMateriel();
	}

}
