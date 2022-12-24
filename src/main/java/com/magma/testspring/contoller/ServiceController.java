package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Anomalie;
import com.magma.testspring.model.Services;
import com.magma.testspring.repository.ServicesRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/service")
public class ServiceController {
	
	private final ServicesRepository servicesRepository;

	@Autowired
	public ServiceController(ServicesRepository servicesRepository) {
		super();
		this.servicesRepository = servicesRepository;
	}
	
	//Find All Services 
	@GetMapping("/allService")
	public List<Services> findAllService(){
		return servicesRepository.findAll();
	}
	

}
