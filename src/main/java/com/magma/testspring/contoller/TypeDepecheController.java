package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.magma.testspring.model.TypeDepeche;
import com.magma.testspring.repository.TypeDepecheRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/typeDepeche")
public class TypeDepecheController {
	
	private final TypeDepecheRepository typeDepecheRepository;

	@Autowired
	public TypeDepecheController(TypeDepecheRepository typeDepecheRepository) {
		super();
		this.typeDepecheRepository = typeDepecheRepository;
	}
	//Find All Users 
	@GetMapping("/allTypeDepeche")
	public List<TypeDepeche> findAllTypeDepeche(){
		return typeDepecheRepository.findAll();
	}
	

}
