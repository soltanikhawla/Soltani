package com.magma.testspring.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magma.testspring.model.Station;
import com.magma.testspring.services.StationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/station")
public class StationController {
	
	private final StationService stationService;

	public StationController(StationService stationService) {
		super();
		this.stationService = stationService;
	}
	
	//Find All Users 
	@GetMapping("/allStation")
	public List<Station> findAllStation(){
		return stationService.findAllStation();
	}
}
